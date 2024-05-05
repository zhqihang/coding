package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 字母异位词分组
 */
public class Demo_049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 统计字母出现次数
        // map : 字符串--字符串列表
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int len = str.length();
            // 统计字母出现次数
            for (int j = 0; j < len; j++) {
                counts[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (counts[j] != 0) {
                    sb.append('a' + j);
                    sb.append(counts[j]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
