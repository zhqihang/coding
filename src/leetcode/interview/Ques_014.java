package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/02
 * @Project: coding
 * @Description: 最长公共前缀
 */
public class Ques_014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null && strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        // 比较逻辑
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && (str1.charAt(index) == str2.charAt(index))) {
            index++;
        }
        return str1.substring(0, index);
    }

}
