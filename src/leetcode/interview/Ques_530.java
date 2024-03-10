package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/19
 * @Project: coding
 * @Description: 二叉搜索树的最小绝对差
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class Ques_530 {

    int pre;
    int ans;

    // 二叉搜索树中序遍历的值序列是递增有序的
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre==-1){
            pre=root.val;
        }else {
            ans = Math.min(ans, root.val -pre);
            pre = root.val;
        }
        dfs(root.right);
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
