package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhqihang
 * @Date: 2024/05/06
 * @Project: coding
 * @Description: 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 滑动窗口解决
 * 思路1: 哈希表 维护字符第一次出现的位置, 根据put方法的返回值判断是否出现重复字符
 *
 * 思路2: 数组 维护字符第一次出现的位置, 寻找 每个位置 结尾 的 无重复字符子串窗口
 *       右边界来到字符 x 此时 左边界 = max(左边界，字符x上一次出现的位置 + 1)
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class Demo_003 {

    public int lengthOfLongestSubstring1(String s) {
        // 记录字符第一次出现的位置
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        // 从第一个字符开始向后遍历
        for (int right = 0; right < chars.length; right++) {
            // 记录第一次的位置
            Object index = map.put(chars[right], right); // 返回 null 或者 被替换掉的value
            while (index != null) {
                // 更新左边界 此时 index 和 index+1 位置是相同的字符
                left = Math.max(left, (int) index + 1);
                // 继续操作: 更新答案 进行下一轮for循环
                break;
            }
            // 更新答案
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    // 寻找 每个位置 结尾 的 无重复字符子串窗口
    // 右边界来到字符 x 此时 左边界 = arrIndex.max(左边界，字符x上一次出现的位置 + 1)
    public int lengthOfLongestSubstring2(String s) {
        // 记录字符第一次出现的位置
        // char 0 ~ 255
        int[] last = new int[26];
        int ans = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        Arrays.fill(last, -1);
        for (int right = 0; right < s.length(); right++) {
            // 更新左边界
            left = Math.max(left, last[chars[right]] + 1);
            // 更新答案
            ans = Math.max(ans, right - left + 1);
            // 更新字符最近一次出现的位置
            last[chars[right]] = right;
        }
        return ans;
    }

}
