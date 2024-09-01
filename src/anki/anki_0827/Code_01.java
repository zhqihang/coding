package anki.anki_0827;

import java.util.Scanner;

/**
 * @description: 丑数
 * @author: zhqihang
 * @date: 2024/08/27
 */
public class Code_01 {

    public static void main(String[] args) {
            
    }

    // 第 n 个丑数
    public static int nthUglyNumber(int n) {

        // 动态规划
        // 所有的丑数都是由前面的丑数乘以 2 3 5 得到的
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2, i2 = 1, i3 = 1, i5 = 1, a, b, c; i <= n; i++) {
            a = dp[i2] * 2;
            b = dp[i3] * 3;
            c = dp[i5] * 5;
            dp[i] = Math.min(Math.min(a, b), c);
            if (dp[i] == a) i2++;
            if (dp[i] == b) i3++;
            if (dp[i] == c) i5++;
        }
        return dp[n];
    }


    // 三个指针
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2, i2 = 1, i3 = 1, i5 = 1, a, b, c; i <= n; i++) {
            // 计算预选的丑数 即三个指针乘积
            a = dp[i2] * 2;
            b = dp[i3] * 3;
            c = dp[i5] * 5;
            // 确定下一个丑数
            dp[i] = Math.min(Math.min(a, b), c);
            // 更新指针
            if (a == dp[i]) i2++;
            if (b == dp[i]) i3++;
            if (c == dp[i]) i5++;
        }
        return dp[n];
    }
}
