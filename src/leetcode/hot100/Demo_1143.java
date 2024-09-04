package leetcode.hot100;

import java.util.Arrays;

/**
 * @description: 最长公共子序列
 * @author: zhqihang
 * @date: 2024/09/04
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。
 * 如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：
 *  它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class Demo_1143 {

    private char[] s, t;
    private int[][] memo;
    // 多维动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();
        int n = s.length;
        int m = t.length;
        memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(n - 1, m - 1);
    }
    // dfs
    private int dfs(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j]; // 之前计算过
        if (s[i] == t[j]) return memo[i][j] = dfs(i - 1, j - 1) + 1;
        return memo[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
    }
}
