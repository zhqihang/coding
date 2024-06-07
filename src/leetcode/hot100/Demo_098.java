package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/06/07
 * @Project: coding
 * @Description: 验证二叉搜索树
 *
 * https://leetcode.cn/problems/validate-binary-search-tree
 *
 */
public class Demo_098 {
    public static long min, max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        // 递归左树
        boolean lok = isValidBST(root.left);
        long lmin = min;
        long lmax = max;
        // 递归右树
        boolean rok = isValidBST(root.right);
        long rmin = min;
        long rmax = max;
        // 向上返回
        min = Math.min(Math.min(lmin, rmin), root.val);
        max = Math.max(Math.max(lmax, rmax), root.val);
        return lok && rok && lmax < root.val && root.val < rmin;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
