package leetcode.interview;

import java.util.LinkedList;

/**
 * @Author: zhqihang
 * @Date: 2024/01/18
 * @Project: coding
 * @Description: 对称二叉树
 * 给你一个二叉树节点root， 检查是否轴对称
 * <p>
 * 使用递归和迭代两种方式
 */
public class Ques_101 {

    /**
     * 递归解决
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        return cheek(root, root);
    }

    private boolean cheek(TreeNode p, TreeNode q) {
        // 两个子树形状相同
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // 判断轴对称：
        // 1. 两个根节点具有相同的值
        // 2. 每个树的右子树都与另一个树的左子树镜像对称
        return p.val == q.val
                && cheek(p.left, q.right)
                && cheek(p.right, q.left);
    }

    /**
     * 引入队列 递归转化为迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return cheek1(root, root);
    }

    private boolean cheek1(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        //  双向链表 LinkList 实现队列  offer入队  poll出队
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            // 每次出队两个元素 应该是相等的
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }

        return true;
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
