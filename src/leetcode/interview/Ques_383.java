package leetcode.interview;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/01/12
 * @Project: coding
 * @Description: 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class Ques_383 {

    // 映射数组实现
    public boolean canConstruct(String ransomNote, String magazine) {
        // 字母计数数组
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i < 0) return false;
        }
        return true;
    }

    // 标准哈希实现
    public boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ransomNoteChar = ransomNote.toCharArray();
        char[] magazineChar = magazine.toCharArray();

        // 遍历统计magazine中的字母个数
        for (char c : magazineChar) {
            int num = map.getOrDefault(c, 0) + 1;
            map.put(c, num);
        }
        for (char c : ransomNoteChar) {
            int num = map.getOrDefault(c, 0) - 1;
            if (num < 0) return false;
            map.put(c, num);
        }
        return true;
    }
}
