package leetcode.interview;

import java.util.LinkedList;

/**
 * @Author: zhqihang
 * @Date: 2024/01/18
 * @Project: coding
 * @Description: 路径总和
 *
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum。
 * 如果存在，返回 true；否则，返回 false。
 */
public class Ques_112 {

    /**
     * 递归方法：
     * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：
     * 是否存在从当前节点的子节点到叶子的路径，满足其路径和为 targetSum - val。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
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

    /**
     * 广度优先搜索
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        // 存放要遍历的节点
        LinkedList<TreeNode> queNode = new LinkedList<>();
        // 存放根节点到这些节点的路径和
        LinkedList<Integer> queVal = new LinkedList<>();

        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()){

            TreeNode now = queNode.poll();
            int temp = queVal.poll();

            if (now.left == null && now.right == null) {
                // 出口
                if (temp == targetSum){
                    return true;
                }
                continue;
            }
            // 入队
            if (now.left != null){
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            // 入队
            if (now.right != null){
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

}
