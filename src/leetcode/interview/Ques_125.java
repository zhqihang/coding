package leetcode.interview;

import javax.xml.stream.events.Characters;

/**
 * @Author: zhqihang
 * @Date: 2024/01/12
 * @Project: coding
 * @Description: ...
 */
public class Ques_125 {

    // 双指针
    public boolean isPalindrome(String s) {
        // 字符串处理：去除空格变小写
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }

        int n = sb.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // 反转 比较
    public boolean isPalindrome1(String s) {
        // 字符串处理
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }

        StringBuffer s_rev = new StringBuffer(sb).reverse();
        return s.toString().equals(s_rev);
    }
}
