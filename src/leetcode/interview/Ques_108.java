package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/20
 * @Project: coding
 * @Description: 有序数组转化为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，
 * 请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 二叉搜索树 中序遍历是有序的
 * 有序数组就是二叉搜索树的中序遍历结果
 * <p>
 * 给定二叉搜索树的中序遍历结果，不能唯一的确定一个二叉搜索树
 * 因为 任意一个数字都可以作为二叉搜索树的根节点
 */
public class Ques_108 {


    // 总是选择中间靠左的节点作为根节点
    // 时间复杂度：n 空间复杂度：log n
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        // 递归左树
        root.left = helper(nums, left, mid - 1);
        // 递归右树
        root.right = helper(nums, mid + 1, right);

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
