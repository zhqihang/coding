package leetcode.interview;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/01/14
 * @Project: coding
 * @Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
 */
public class Ques_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        // 使用一个hashmap记录单词和出现次数？
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer num = map.getOrDefault(ch, 0);
            map.put(ch, num + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            Integer num = map.getOrDefault(ch, 0);
            if (num <= 0) {
                return false;
            }
            map.put(ch, num - 1);
        }
        return true;
    }
}
