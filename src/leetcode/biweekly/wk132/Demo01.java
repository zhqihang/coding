package leetcode.biweekly.wk132;

import java.util.ArrayList;

/**
 * @Author: zhqihang
 * @Date: 2024/06/08
 * @Project: coding
 * @Description: 清除数字
 * 给你一个字符串 s 。
 * 你的任务是重复以下操作删除 所有 数字字符：
 * - 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 *
 * https://leetcode.cn/contest/biweekly-contest-132/problems/clear-digits/description/
 */
public class Demo01 {
    public static int MAXN;

    public static char[] stack = new char[MAXN];

    public static int right;

    public String clearDigits(String s) {
        right = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (right != 0 && !Character.isDigit(stack[right])) {
                    right--;
                }
            } else {
                stack[right++] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < right; i++) {
            sb.append(stack[i]); // 仅添加有效字符部分
        }
        return sb.toString();
    }
}
