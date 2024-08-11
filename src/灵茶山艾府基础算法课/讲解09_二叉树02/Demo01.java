package 灵茶山艾府基础算法课.讲解09_二叉树02;

/**
 * @description: 相同的树
 * @author: zhqihang
 * @date: 2024/08/11
 * https://leetcode.cn/problems/same-tree/description/
 */

/*
    递：相同的树 --> 左右子树都是相同的树
    边界条件：左右子树仅有一个为空

 */
public class Demo01 {

    // 简写
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        // 边界条件
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p == null && q == null) return true;
        if (p.val != q.val) return false; // 判断值
        // 递
        // 左子树
        boolean l = isSameTree1(p.left, q.left);
        // 右子树
        boolean r = isSameTree1(p.right, q.right);
        if (r && l ) return true;
        return false;
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
