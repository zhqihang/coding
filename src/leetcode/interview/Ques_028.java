package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/02
 * @Project: coding
 * @Description: 给你两个字符串 haystack 和 needle
 * 请你在 haystack 字符串中找出 needle字符串的第一个匹配项的下标（下标从 0 开始）
 * 如果 needle 不是 haystack 的一部分，则返回 -1
 */
public class Ques_028 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        // i + n 是 haystack 子串的起始位置
        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            // 遍历这一位置开始的所有长度子串
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
