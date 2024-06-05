package leetcode.hot100;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/06/04
 * @Project: coding
 * @Description: 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * https://leetcode.cn/problems/symmetric-tree/description
 *
 */
public class Demo_101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
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
