package 灵茶山艾府基础算法课.讲解09_二叉树01递归;

/**
 * @description: 二叉树的最大深度
 * @author: zhqihang
 * @date: 2024/08/11
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */

/*
二叉树的最大深度问题
    二叉树与递归：
        原问题：计算整棵树的最大深度
        子问题：计算左右子树的最大深度
        原问题和子问题是相似的！执行代码也应是相同的，子问题需要把计算结果返回给上一级问题（使用变量统计）
        这种问题 适合用 递归 实现，正确性可以使用 数学归纳法 证明
    1. 递：原问题 -- 子问题
    2. 边界条件：base case（此问题边界条件为 0）
    3. 归：子问题结果返回给上一级问题
 */

public class Demo01 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 递归实现
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int ans = Math.max(left, right);
        return ans + 1; // 加一是加入当前节点的高度
    }
    /*
    时间复杂度：O(n)，其中 n 为二叉树的节点个数。
    空间复杂度：O(n)。最坏情况下，二叉树退化成一条链，递归需要 O(n) 的栈空间。
     */
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
