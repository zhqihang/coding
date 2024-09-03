package leetcode.hot100;

/**
 * @description: 最长有效括号
 * @author: zhqihang
 * @date: 2024/09/01
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 */
public class Demo_032 {


    public int longestValidParentheses(String str) {
        char[] s= str.toCharArray();
        int[] dp = new int[s.length];
        int ans = 0;
        for (int i = 1, p; i < s.length; i++) {
            if (s[i] == ')') {
                p = i - dp[i - 1] - 1;
                if (p >= 0 && s[p] == '(') {
                    dp[i] = dp[i - 1] + 2 + (p - 1 > 0 ? dp[p - 1] : 0);
                } else {
                    dp[i] = 0;
                }
            } else {
                dp[i] = 0;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    // 左程云算法课 一维动态规划 例题
    public int longestValidParentheses1(String str) {
        char[] s = str.toCharArray();
        // dp[i] 代表子串必须以 i 位置结尾 往左可以匹配多少有效长度
        int[] dp = new int[s.length];
        int ans = 0;
        for (int i = 1, p; i < s.length; i++) {
            // 1. 如果当前位置是左括号 则 dp[i] = 0
            // 2. 如果当前位置是右括号 往前 dp[i - 1]+1 跳到前一个位置能匹配到的p位置 （i - dp[i - 1] - 1）
            //  2.1 p位置是右括号 不匹配 dp[i] = 0
            //  2.2 p位置是左括号 匹配 dp[i] = dp[i - 1] + 2 + dp[p - 1]
            if (s[i] == ')') {
                // 前一个位置能到达的有效位置
                p = i - dp[i - 1] - 1;
                // 继续判断
                if (p >= 0 && s[p] == '(') {
                    // 只需要往前跳一步 （dp[p - 1] 已经包含了之前的有效长度）
                    // dp[i] = dp[i - 1] + 2 （起码是2）+ dp[p - 1]
                    dp[i] = dp[i - 1] + 2 + (p - 1 > 0 ? dp[p - 1] : 0); // 是否越界
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
