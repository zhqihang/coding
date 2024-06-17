package leetcode.everyday.June;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/06/16
 * @Project: coding
 * @Description: 最长特殊子序列
 * 给你两个字符串 a 和 b，请返回 这两个字符串中 最长的特殊序列  的长度。如果不存在，则返回 -1 。
 * 「最长特殊序列」 定义如下：该序列为 某字符串独有的最长  子序列  （即不能是其他字符串的子序列） 。
 * 字符串 s 的子序列是在从 s 中删除任意数量的字符后可以获得的字符串。
 * 例如，"abc" 是 "aebdc" 的子序列，因为删除 "aebdc" 中斜体加粗的字符可以得到 "abc" 。
 * "aebdc" 的子序列还包括 "aebdc" 、 "aeb" 和 "" (空字符串)。
 * https://leetcode.cn/problems/longest-uncommon-subsequence-i/description/
 */
public class Demo_0616 {

    // 是最长 且 不能是对方的
    public int findLUSlength(String a, String b) {
        // 如果两个长度不一样 那么返回最长的
        if (a.length() != b.length()) return Math.max(a.length(), b.length());
        // 如果两个长度一样
        return a.equals(b) ? -1 : a.length();
    }


    public int findLUSlength1(String[] strs) {
        int n = strs.length, ans = -1;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() <= ans) continue;
            boolean ok = true;
            for (int j = 0; j < n && ok; j++) {
                if (i == j) continue;
                if (check(strs[i], strs[j])) ok = false;
            }
            if (ok) ans = strs[i].length();
        }
        return ans;
    }

    boolean check(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m < n) return false;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? f[i - 1][j - 1] + 1 : f[i - 1][j - 1];
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                if (f[i][j] == n) return true;
            }
        }
        return false;
    }

}
