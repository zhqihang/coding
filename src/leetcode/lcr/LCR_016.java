package leetcode.lcr;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/04/30
 * @Project: coding
 * @Description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 */
public class LCR_016 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        // 遍历字符串的每个字符
        int ans = 0, right = -1;
        for (int left = 0; left < s.length(); left++) {
            // 左指针移动逻辑
            if (left != 0) set.remove(s.charAt(left - 1));

            // 向右移动右指针 统计 i 位置起始的
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
