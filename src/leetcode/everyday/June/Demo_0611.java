package leetcode.everyday.June;

/**
 * @Author: zhqihang
 * @Date: 2024/06/11
 * @Project: coding
 * @Description: 甲板上的战舰
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，
 * 其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
 * 返回在甲板 board 上放置的 战舰 的数量。
 * <p>
 * 战舰 只能水平或者垂直放置在 board 上。
 * 换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，
 * 其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 * <p>
 * 输入：board = [["X",".",".","X"],
 * [".",".",".","X"],
 * [".",".",".","X"]]
 * 输出：2
 * https://leetcode.cn/problems/battleships-in-a-board/description/
 * <p>
 * 思路: 战舰的个数 等于 战舰 头部 的个数
 * 如果 (i, j) 是 战舰的头部 那么 它左边和上边的相邻格子不能是 X
 * - if j > 0  (i, j - 1) !X
 * - if i > 0  (i - 1, j) !X
 */
public class Demo_0611 {
    // 不重叠的 X 空间
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 只统计头部个数 其余不统计
                if (board[i][j] == 'X'
                        && (j == 0 || board[i][j - 1] != 'X')
                        && (i == 0 || board[i - 1][j] != 'X')) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
