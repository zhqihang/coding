package leetcode.biweekly.wk132;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/06/09
 * @Project: coding
 * @Description: k秒后第 N 个元素的值
 * 给你两个整数 n 和 k。
 * 最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1 。
 * 每过一秒，你会同时更新每个元素为其前面所有元素的和加上该元素本身。
 * 例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] + a[2]，以此类推。
 * 返回 k 秒后 a[n - 1] 的值。
 * 由于答案可能非常大，返回其对 10^9 + 7 取余 后的结果。
 * https://leetcode.cn/contest/weekly-contest-401/problems/find-the-n-th-value-after-k-seconds/
 */
public class Demo_06 {
    private static final int MOD = 1000000007;

    // 每过一秒 所有元素同时更新
    public static int valueAfterKSeconds(int n, int k) {
        return combination(n + k - 1, k);
    }

    private static int combination(int n, int k) {
        if (k == 0 || k == n) return 1;
        long[] dp = new long[k + 1];
        dp[0] = 1; // C(n, 0) = 1
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        return (int) dp[k];
    }

    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(3, 5));
    }
}
