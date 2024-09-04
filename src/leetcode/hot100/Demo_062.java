package leetcode.hot100;

/**
 * @description: 不同路径
 * @author: zhqihang
 * @date: 2024/09/04
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * https://leetcode.cn/problems/unique-paths/description/
 */
public class Demo_062 {
    // 多维动态规划
    public int uniquePaths(int m, int n) {
        // dp数组表示到达当前坐标 的 路径个数
        int[][] dp = new int[m][n];
        // 初始状态（左边界和上边界的位置只有一种路径，设置为 1）
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        // 转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 上方个数 + 左方个数
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 优化dp
    public int uniquePaths1(int m, int n) {
        // dp[i] 数组
        int[] dp = new int[n];
        // 初始化数组
        for (int i = 0; i < n; i++) dp[i] = 1;
        // 滚动数组
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
