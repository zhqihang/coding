package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/06/17
 * @Project: coding
 * @Description: 二叉树节点的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Demo_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 树为空 || 有一个是祖先 返回
        if (root == null || root == p || root == q) return root;
        // 递归左右子树
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        // 左右子树都有找到 返回公共祖先
        if (l != null && r != null) return root;
        // 左右子树都没找到 返回空
        if (l == null && r == null) return null;
        // 左右子树 有一个找到
        return l == null ? r : l;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
