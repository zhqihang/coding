package leetcode.codetop;

/**
 * @description: 最长回文子串
 * @author: zhqihang
 * @date: 2024/07/28
 */
public class Q005 {
    // https://leetcode.cn/problems/longest-palindromic-substring/description/
    // 动态规划解法
    public String longestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString(); // 反转字符串
        int n = s.length();
        int[][] f = new int[n][n]; // 动态规划数组
        int maxLen = 1; // 回文子串的长度
        int begPos = 0; // 回文子串起始位置
        // dp填表
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 如果相等
                if (s.charAt(i) == rev.charAt(j)) {
                    if (i == 0 || j == 0) f[i][j] = 1;
                    else f[i][j] = f[i - 1][j - 1] + 1;
                }
                // 更新回文子串的信息
                if (f[i][j] > maxLen) {
                    int befPos = n - j - 1;
                    // 检查回文子串是否与原字符位置相对应
                    if (befPos + f[i][j] - 1 == i) {
                        maxLen = f[i][j];
                        begPos = befPos;
                    }
                }
            }
        }
        return s.substring(begPos, begPos + maxLen);
    }
}
