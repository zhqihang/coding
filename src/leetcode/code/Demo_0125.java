package leetcode.code;

/**
 * @description: 验证回文串
 * @author: zhqihang
 * @date: 2024/07/28
 */
public class Demo_0125 {
    public static boolean isPalindrome(String s) {
        // 字符处理过程
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }
        // 验证回文串过程
        // 注意 StringBuilder 的 reverse 方法会修改 原对象的内容 而不是一个新的字符串
        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());
        if (!sb.reverse().toString().equals(sb.toString())) return false;
        return true;
    }
}
