package leetcode.lcr;

/**
 * @Author: zhqihang
 * @Date: 2024/03/14
 * @Project: coding
 * @Description: 矩阵中的路径
 * <p>
 * 字母迷宫游戏初始界面记作 m x n 二维字符串数组 grid，请判断玩家是否能在 grid 中找到目标单词 target。
 * 注意：寻找单词时 必须 按照字母顺序，通过水平或垂直方向相邻的单元格内的字母构成，同时，同一个单元格内的字母 不允许被重复使用 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = "ABCCED"
 * 输出：true
 */
public class LCR_129 {
    public static void main(String[] args) {
        char[][] grid = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String target = "ABCCED";
        System.out.println("wordPuzzle(grid, target) = " + wordPuzzle(grid, target));
    }


    // 回溯算法: 深度优先搜索 + 可行性剪枝
    public static boolean wordPuzzle(char[][] grid, String target) {
        char[] words = target.toCharArray();
        for (int i = 0; i < grid.length; i++) { // 遍历行
            for (int j = 0; j < grid[0].length; j++) { // 遍历列
                if (dfs(grid, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    // 矩阵 单词 行索引 列索引 字母索引
    private static boolean dfs(char[][] grid, char[] target, int i, int j, int k) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != target[k]) return false;
        if (k == target.length - 1) return true;
        grid[i][j] = '\0'; // 遍历过后 设为空

        boolean res =
                dfs(grid, target, i + 1, j, k + 1) || // 向下
                        dfs(grid, target, i - 1, j, k + 1) || // 向上
                        dfs(grid, target, i, j + 1, k + 1) || // 向右
                        dfs(grid, target, i, j - 1, k + 1); // 向左
        grid[i][j] = target[k];
        return res;
    }
}
