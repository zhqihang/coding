package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhqihang
 * @Date: 2024/06/04
 * @Project: coding
 * @Description: 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 */
public class Demo_094 {

    // 递归中序遍历
    public List<Integer> inorderTraversal1(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        inorder(head, ans);
        return ans;
    }

    // 左右中
    private void inorder(TreeNode head, List<Integer> ans) {
        if (head == null) return;
        inorder(head.left, ans);
        ans.add(head.val);
        inorder(head.right, ans);
    }

    // 栈实现非递归中序遍历
    public List<Integer> inorderTraversal(TreeNode head) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    ans.add(head.val); // 收集答案
                    head = head.right;
                }
            }
        }
        return ans;
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
