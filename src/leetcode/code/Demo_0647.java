package leetcode.code;

/**
 * @Author: zhqihang
 * @Date: 2024/06/08
 * @Project: coding
 * @Description: 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * https://leetcode.cn/problems/palindromic-substrings/description/
 */
public class Demo_0647 {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        boolean[][] dp = new boolean[n][n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (chars[i] == chars[j]) {
                    if (i - j <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i - 1][j + 1]) {
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
