package leetcode.hot100;

/**
 * @description: 最小路径和
 * @author: zhqihang
 * @date: 2024/09/04
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * https://leetcode.cn/problems/minimum-path-sum/description/
 */
public class Demo_064 {
    // 多维动态规划
    // 最小路径和
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp 数组代表到达当前坐标的 最小花费
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始状态
        // 第一列
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        // 第一行
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
