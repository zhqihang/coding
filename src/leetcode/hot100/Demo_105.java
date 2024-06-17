package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/06/17
 * @Project: coding
 * @Description: 前序 中序 构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 */
public class Demo_105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
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
