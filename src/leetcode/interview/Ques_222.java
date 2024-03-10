package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/19
 * @Project: coding
 * @Description: 完全二叉树上的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class Ques_222 {


    // 完全二叉树的特性
    // 它是一棵空树或者它的叶子节点只出在最后两层，若最后一层不满则叶子节点只在最左侧
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        // 左树高度
        int left = countLevel(root.left);
        // 右树高度
        int right = countLevel(root.right);

        // 如果左右高度一致-->左树满，右树不一定
        if (left == right) {
            // 递归右子树 + 左子树节点数（2^left-1） + 根节点
            return countNodes(root.right) + (int) Math.pow(2, left);
            // return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (int) Math.pow(2, right);
            // return countNodes(root.left) + (1 << right);
        }
    }

    // 计算完全二叉树的高度
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }


    // 遍历树节点
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
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


