package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/06/17
 * @Project: coding
 * @Description: 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode.cn/problems/binary-tree-right-side-view/description
 *
 * 思路: 层序遍历 每层的最后一个节点
 *
 */
public class Demo_199 {

    // 数组实现队列
    public static int MAXN = 101;
    public static TreeNode[] queue = new TreeNode[MAXN];
    public static int l, r;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root; // 入队
            while (l < r) {
                int size = r - l;
                for (int i = 0; i < size; i++) {
                    // 出队
                    TreeNode cur = queue[l++];
                    // 如果是本层最后一个节点，加入右视图
                    if (i == size - 1) {
                        rightView.add(cur.val);
                    }
                    // 孩子入队
                    if (cur.left != null) queue[r++] = cur.left;
                    if (cur.right != null) queue[r++] = cur.right;
                }
            }
        }
        return rightView;
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
