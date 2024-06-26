package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/06/21
 * @Project: coding
 * @Description: 二叉树转化为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * - 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * - 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 *
 */
public class Demo_114 {
    public static List<TreeNode> list = new ArrayList<>();

    // 先序遍历 然后重组链表
    public void flatten(TreeNode root) {
        // 如果是空节点
        if (root == null) return;
        dfs(root);
        // 组装单链表树
        int size = list.size();
        for (int i = 1; i < size; i++) {
            // 获取前置节点
            TreeNode preNode = list.get(i - 1);
            // 当前节点
            TreeNode curNode = list.get(i);
            preNode.left = null;
            preNode.right = curNode;
        }

        /*
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        // 最后一个节点
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
         */
    }

    // 先序遍历
    private void dfs(TreeNode root) {
        if (root == null) return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
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
