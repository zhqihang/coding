package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/18
 * @Project: coding
 * @Description: 翻转二叉树
 * <p>
 * 给你一颗二叉树的根节点root， 翻转这课二叉树，并返回其根节点
 */

public class Ques_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 递归操作
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 翻转操作
        root.left = right;
        root.right = left;

        return root;
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
