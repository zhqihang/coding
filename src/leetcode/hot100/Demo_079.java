package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/07/11
 * @Project: coding
 * @Description: 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Demo_079 {

    // 单词搜索 回溯 深度优先搜索 + 剪枝操作
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    // ij是元素在矩阵中的坐标 k是目标字符在 word 中的索引
    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 越界 或者 不是需要的字符
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        // 遍历到最后一个字符 还存在(没有越界)
        if (k == word.length - 1)
            return true;
        board[i][j] = '\0'; // 置为访问标记: 空字符
        // 四个方向递推
        boolean res = dfs(board, word, i + 1, j, k + 1) ||  // 向下
                dfs(board, word, i - 1, j, k + 1) ||        // 向上
                dfs(board, word, i, j + 1, k + 1) ||        // 向下
                dfs(board, word, i, j - 1, k + 1);          // 向上
        board[i][j] = word[k]; // 还原访问标记为初始值
        return res;
    }
}
