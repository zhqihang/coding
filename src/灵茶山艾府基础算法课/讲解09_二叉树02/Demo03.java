package 灵茶山艾府基础算法课.讲解09_二叉树02;

/**
 * @description: 平衡二叉树
 * @author: zhqihang
 * @date: 2024/08/11
 * https://leetcode.cn/problems/balanced-binary-tree
 */
public class Demo03 {

    /*
    平衡二叉树：高度一致就是平衡二叉树

    递：左右子树都是高度一致的
    边界条件：左右节点有一个为空的
     */

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs((left - right)) > 1 ? -1 : Math.max(left, right) + 1;
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
