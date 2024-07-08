package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/03/03
 * @Project: coding
 * @Description: https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 */
public class Ques_003 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        // 外层循环 从字符串的第一个字符开始 遍历所有字符
        for (int i = 0; i < s.length(); i++) {
            boolean[] book = new boolean[300];
            // 内层循环 从当前字符向前遍历 判断最长不重复子串长度
            for (int j = i; j >= 0; j--) {
                // 如果已经出现过, 结束内层循环
                if (book[s.charAt(j)])
                    break;
                // 标记当前字符出现过
                book[s.charAt(j)] = true;
                // 更新最长子串长度
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
