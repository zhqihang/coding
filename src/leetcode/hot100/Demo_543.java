package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/06/07
 * @Project: coding
 * @Description: 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 *
 */
public class Demo_543 {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null) return -1;
        int lLen = dfs(node.left) + 1;
        int rLen = dfs(node.right) + 1;
        ans = Math.max(ans, lLen + rLen);
        return Math.max(lLen, rLen);
    }

    public class TreeNode {
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
