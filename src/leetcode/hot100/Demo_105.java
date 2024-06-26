package leetcode.hot100;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/06/17
 * @Project: coding
 * @Description: 前序 中序 构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中
 * preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class Demo_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length; // 树节点个数
        if (n == 0) return null;
        // 左子树大小
        int leftSize = indexOf(inorder, preorder[0]);
        // 左子树
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        // 右子树
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        // 分别递归两边
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);
    }

    // 返回 x 在 arr 中的下标
    private int indexOf(int[] arr, int x) {
        for (int i = 0; ; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
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
