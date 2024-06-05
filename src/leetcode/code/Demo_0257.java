package leetcode.code;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/06/04
 * @Project: coding
 * @Description: 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * <p>
 * https://leetcode.cn/problems/binary-tree-paths/description/
 */
public class Demo_0257 {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer sb = new StringBuffer(path);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                dfs(root.left, sb.toString(), paths);
                dfs(root.right, sb.toString(), paths);
            }
        }
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
