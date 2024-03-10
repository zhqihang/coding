package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/20
 * @Project: coding
 * @Description: 二进制求和
 * <p>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 考虑：
 * 1. 两个数的位数不一致
 * 2. 字符串和数字之间的相互转化
 */
public class Ques_067 {
    // 直接转化为十进制求和之后返回
    // 会存在位数限制的问题
    public static String addBinary(String a, String b) {
        // StringBuilder效率高 线程不安全
        StringBuilder ans = new StringBuilder();

        // 确定遍历的次数
        int n = Math.max(a.length(), b.length());
        // 进位
        int carry = 0;

        // 遍历按位求和
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;

            ans.append((char) (carry % 2 + '0')); // 这里使用ASCII码进行字符转化
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }

        ans.reverse();
        return ans.toString();
    }

}
