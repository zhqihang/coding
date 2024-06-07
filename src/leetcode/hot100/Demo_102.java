package leetcode.hot100;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/06/06
 * @Project: coding
 * @Description: 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 */
public class Demo_102 {

    // 数组实现队列
    public static int MAXN = 2001;
    public static TreeNode[] queue = new TreeNode[MAXN];
    public static int l, r;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root; // 入队
            while (l < r) {
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    // 出队
                    TreeNode cur = queue[l++];
                    // 加入本层链表
                    list.add(cur.val);
                    // 孩子入队
                    if (cur.left != null) queue[r++] = cur.left;
                    if (cur.right != null) queue[r++] = cur.right;
                }
                ans.add(list);
            }
        }
        return ans;
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
