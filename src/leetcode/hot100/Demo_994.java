package leetcode.hot100;

import java.util.ArrayList;

/**
 * @Author: zhqihang
 * @Date: 2024/06/08
 * @Project: coding
 * @Description: 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * - 值 0 代表空单元格；
 * - 值 1 代表新鲜橘子；
 * - 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * https://leetcode.cn/problems/rotting-oranges/description
 *
 */
public class Demo_994 {

    // 定义四个方向
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        ArrayList<int[]> q = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是新鲜的橘子
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    // 一开始就腐烂的橘子
                    q.add(new int[]{i, j});
                }
            }
        }
        int ans = -1;
        while (!q.isEmpty()) {
            ans++; // 一分钟
            ArrayList<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] pos : tmp) { // 已经腐烂的橘子
                for (int[] direction : DIRECTIONS) {
                    // 传染过程
                    int i = pos[0] + direction[0];
                    int j = pos[1] + direction[1];
                    // 如果位置合法 并且是个新鲜橘子
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        fresh--;
                        grid[i][j] = 2;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : Math.max(ans, 0);
    }
}
