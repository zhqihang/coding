package leetcode.hot100;

import java.util.*;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 字母异位词分组
 */
public class Demo_049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 统计字母出现的次数
        // map : 字符串 字符串列表
        HashMap<String, List<String>> map = new HashMap<>();
        // 遍历每一个字符串
        for (String str : strs) {
            int[] counts = new int[26]; // 字母数组
            int len = str.length();
            // 统计字母出现次数
            for (int i = 0; i < len; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append('a' + i);
                    sb.append(counts[i]);
                }
            }
            String string = sb.toString();
            // 存在则返回 不存在返回新建的列表
            List<String> list = map.getOrDefault(string, new ArrayList<>());
            // 当前字符串加入链表
            list.add(str);
            // 当前键值对 加入集合
            map.put(string, list);
        }
        // return new ArrayList<>(map.values());
        // 这里根据map value 长度进行排序
        List<List<String>> ans = new ArrayList<>(map.values());
        ans.sort(Comparator.comparingInt(List::size));
        return ans;
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        // 统计字母出现次数
        // map : 字符串--字符串次数列表
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int len = str.length();
            // 统计字母出现次数
            for (int j = 0; j < len; j++) {
                counts[str.charAt(j) - 'a']++;
            }
            // 遍历字符
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (counts[j] != 0) {
                    sb.append('a' + j);
                    sb.append(counts[j]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str); // 加入答案列表
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}