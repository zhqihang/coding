package 左神算法.class00;

import java.util.Stack;

/**
 * @author: qihang
 * @CreateDate: 2023/12/14/ 10:06
 * @Project: coding
 * @Description: 二叉树 三序遍历非递归实现
 */
public class Video_018 {

    // 栈实现非递归先序遍历
    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                // 栈先进后出 先序中左右 先压右再压左
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    // 栈实现非递归中序遍历 左中右
    // 原理还是先处理节点的左树 再到自己 再处理右树
    // 1. 子树的左边界全部进栈 进步骤 2
    // 2. 栈弹出节点并打印 此节点右树重复步骤 1
    // 3. 没有子树, 且栈空结束
    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) { // head != null 有树
                // 步骤1
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                    // 步骤2
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    // 栈实现非递归后序遍历 两个栈
    // 思路: 先序(中左右)---> 中右左 ---> 后序(左右中)
    public static void posOrderTwoStack(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head); // 不打印 按照中右左进栈
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            // 出栈 左右中
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val + " ");
            }
            System.out.println();
        }
    }

    // 栈实现非递归后序遍历 一个栈
    public static void posOrderOneStack(TreeNode h) {
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            // 如果始终没有打印过节点, h就一直是头结点
            // 一旦打印过节点, h就变成打印节点
            // 之后h的含义: 上一次打印的节点
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();// 取栈顶元素
                if (cur.left != null && h != cur.left && h != cur.right) {
                    // 有左树且左树没有被处理过
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    // 有右树且右树没有被处理过
                    stack.push(cur.right);
                } else {
                    // 左树 右树 没有 或者 都被处理过了
                    System.out.print(cur.val + " ");
                    h = stack.pop(); // 指向上次打印节点
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println("后序遍历非递归版");
        posOrderOneStack(head);
    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
}
