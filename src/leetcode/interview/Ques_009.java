package leetcode.interview;

import java.util.LinkedList;

/**
 * @Author: zhqihang
 * @Date: 2024/01/23
 * @Project: coding
 * @Description: 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class Ques_009 {

    // 数字转字符串
    public boolean isPalindrome1(int x) {
        String str1 = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        return str1.equals(sb.reverse().toString());
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 翻转一半数字
        int reverseNum = 0;
        // 原始数字小于等于反转后的数字 则停止
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        // 偶数位 or 奇数位
        return x == reverseNum || x == reverseNum / 10;
    }
}
