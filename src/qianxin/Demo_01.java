package qianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zhqihang
 * @Date: 2024/05/14
 * @Project: coding
 * @Description: double数字
 * 定义 double 数是 位数为偶数且前一半和后一半完全相同的正整数，
 * 如: 1212,11,1010 是double数，而313,25,990不是double数。
 * 牛牛想知道 [1,n] 内有多少double数。
 * 函数传入一个正整数 n ,返回 [1,n] 内double数的个数。 数据范围：1 <= n <= 10^12
 * 输入: 25
 * 输出: 2       说明: [1,25] 内的double数有: 11,22，因此答案为2。
 * 输入: 2
 * 输出: 0       说明: [1,2]内没有double数。
 * 输入: 3154354
 * 输出: 999
 * <p>
 * 思路: 根据数据范围 只需要枚举到长度为6的数字
 * 2位数字时 有 1~9 重复两遍个
 * 4位数字时 有 10~99 重复两遍个
 * 6位数字时 有 100~999 重复两遍个
 * .....
 * 12位数字时 有 100000~999999 重复两遍个
 */
public class Demo_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(f(n));
    }

    // 输入一个数字
    public static int f(int n) {
        int ans = 0;
        for (int i = 2; i <= 12; i += 2) {
            // double数组的起始范围
            int start = (int) Math.pow(10, i / 2 - 1); // 10
            int end = (int) Math.pow(10, i / 2) - 1; // 99
            // 计算答案
            ans += count(start, end, n);
        }
        return ans;
    }

    private static int count(int start, int end, int n) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            // 组织成 double 数字
            long d = Long.parseLong(String.valueOf(i) + String.valueOf(i));
            if (d <= n) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
