package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/06/07
 * @Project: coding
 * @Description: 将有序数组转化为二叉搜索树
 * <p>
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class Demo_108 {
    // 总是选择中间靠左的节点作为根节点
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        // int mid = (left + right) / 2;
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
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
