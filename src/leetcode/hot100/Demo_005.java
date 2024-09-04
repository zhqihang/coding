package leetcode.hot100;

/**
 * @description: 最长回文子串
 * @author: zhqihang
 * @date: 2024/09/04
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * https://leetcode.cn/problems/longest-palindromic-substring/description
 */
public class Demo_005 {
    // 动态规划
    public String longestPalindrome(String s) {
        // dp[i][j] 数组表示 从索引 i 到 j 的子串是否是回文串
        // 如果是 则存储子串的长度 如果不是 则没有实际意义
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLen = 1; // 回文子串的长度
        int begPos = 0; // 回文子串的起始位置
        // 递推方程
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 两个字符进行比较
                if (s.charAt(i) == rev.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    // 更新最长回文子串
                    if (dp[i][j] > maxLen) {
                        int befPos = n - j - 1;
                        // 回文子串是否与原字符位置相对应
                        if (befPos + dp[i][j] - 1 == i) {
                            maxLen = dp[i][j];
                            begPos = befPos;
                        }
                    }
                }
            }
        }
        return s.substring(begPos, begPos + maxLen);
    }
}
