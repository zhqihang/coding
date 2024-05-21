package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 摘樱桃2
 * 给你一个 rows x cols 的矩阵 grid 来表示一块樱桃地。
 * grid 中每个格子的数字表示你能获得的樱桃数目。
 * 你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发。
 * 请你按照如下规则，返回两个机器人能收集的最多樱桃数目：
 * - 从格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) 。(三个方向:左下/下/右下)
 * - 当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。
 * - 当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。
 * - 两个机器人在任意时刻都不能移动到 grid 外面。
 * - 两个机器人最后都要到达 grid 最底下一行。
 * https://leetcode.cn/problems/cherry-pickup-ii/description
 * <p>
 * 解题思路:
 *      三维动态规划
 */
public class Demo_0507 {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m][n][n];
        // 初始化数组
        for (int[][] me : memo) {
            for (int[] r : me) {
                Arrays.fill(r, -1);
            }
        }
        return dfs(0, 0, n - 1, grid, memo);
    }

    private int dfs(int i, int j, int k, int[][] grid, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m || j < 0 || j >= n || k < 0 || k >= n) {
            return 0;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        int res = 0;
        for (int j2 = j - 1; j2 <= j + 1; j2++) {
            for (int k2 = k - 1; k2 <= k + 1; k2++) {
                res = Math.max(res, dfs(i + 1, j2, k2, grid, memo));
            }
        }
        res += grid[i][j] + (k != j ? grid[i][k] : 0);
        memo[i][j][k] = res;
        return res;
    }
}
