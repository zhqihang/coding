package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhqihang
 * @Date: 2024/07/09
 * @Project: coding
 * @Description: 路径总和三
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Demo_437 {

    private int ans;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }
    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) return;
        s += node.val;
        ans += cnt.getOrDefault(s - targetSum, 0);
        cnt.merge(s, 1, Integer::sum);
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // 恢复现场
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