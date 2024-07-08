package leetcode.everyday.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/29
 * @Project: coding
 * @Description: 找出出现至少三次的最长特殊子字符串
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 s 。
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。
 * 例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 * <p>
 * 输入：s = "aaaa"
 * 输出：2
 * 解释：出现三次的最长特殊子字符串是 "aa" ：子字符串
 * <p>
 * https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-i/description/
 */
public class Demo_0529 {

    public int maximumLength(String s) {
        char[] chars = s.toCharArray();
        List<Integer>[] group = new ArrayList[26];
        Arrays.setAll(group, i -> new ArrayList<>());
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt++;
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                // 统计连续字符的长度
                group[chars[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }
        int ans = 0;
        for (List<Integer> a : group) {
            if (a.isEmpty()) continue;
            a.sort(Collections.reverseOrder());
            a.add(0);
            a.add(0);
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));
        }
        return ans > 0 ? ans : -1;
    }
}
