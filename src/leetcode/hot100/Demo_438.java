package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/06
 * @Project: coding
 * @Description: 找到字符串种所有字母的异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 数据规模:
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 * <p>
 * 思路1: 滑动窗口 + 双指针
 */
public class Demo_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // 字符统计数组
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }
        // 答案列表
        ArrayList<Integer> ans = new ArrayList<>();
        // 合法判断
        if (sLen < pLen) return ans;
        // 双指针
        int left = 0;
        for (int right = 0; right < sLen; right++) {
            char ch = s.charAt(right);
            sCnt[ch - 'a']++;

            // right当前遍历到的字符加入s_cnt后不满足p_cnt的字符数量要求，
            // 将滑动窗口左侧字符不断弹出，也就是left不断右移，直到符合要求为止

            // 右指针指向的不符合要求 [left, right] 全部--
            while (sCnt[ch - 'a'] > pCnt[ch - 'a']) {
                sCnt[s.charAt(left) - 'a']--;
                left++;
            }
            // 循环出来时 left == right + 1

            if (right - left + 1 == pLen) {
                ans.add(left);
            }
        }
        return ans;
    }
}
