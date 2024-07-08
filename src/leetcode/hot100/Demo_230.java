package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/06/13
 * @Project: coding
 * @Description: 二叉搜索树中第 k 小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 * <p>
 * 思路: 遍历 + 排序
 * 但是 二叉搜索树的 中序遍历 自然有序
 */
public class Demo_230 {

    int res, k;

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k == 0) return; // 第 0 小的元素
        if (--k == 0) res = root.val; // 如果是了 直接记录返回
        dfs(root.right);
    }

    // 根节点 和 第 k 小的元素
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
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
