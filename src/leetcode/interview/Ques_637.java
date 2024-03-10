package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/01/19
 * @Project: coding
 * @Description: 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。
 * 与实际答案相差 10^-5 以内的答案可以被接受。
 */
public class Ques_637 {

    // 深度优先搜索
    public List<Double> averageOfLevels(TreeNode root) {
        // 需要维护两个数组：
        // 1. 存储二叉树每一层的节点数
        // 2. 存储二叉树每一层的节点值之和
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<Double> sums = new ArrayList<>();

        dfs(root, 0, counts, sums);

        ArrayList<Double> averages = new ArrayList<>();

        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    // 深度优先搜索
    private void dfs(TreeNode root, int level, ArrayList<Integer> counts, ArrayList<Double> sums) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }

        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
