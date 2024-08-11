package 灵茶山艾府基础算法课.讲解09_二叉树02;

/**
 * @description: 对称二叉树
 * @author: zhqihang
 * @date: 2024/08/11
 * https://leetcode.cn/problems/symmetric-tree/description/
 */
public class Demo02 {
    /*
    对称二叉树：左右子树轴对称 -- 可以利用到 相同的树 的代码 颠倒左右子树即可
        递：左右子树都是对称二叉树
        边界条件：左右节点有一个节点为空

     */
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
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


