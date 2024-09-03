package leetcode.hot100;

import java.util.Arrays;

/**
 * @description: 零钱兑换
 * @author: zhqihang
 * @date: 2024/09/03
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class Demo_322 {
    // 动态规划
    public int coinChange(int[] coins, int amount) {
        // 原问题：选择硬币 组成 金额 硬币数要最小
        // 子问题：选择剩下的硬币，组成 剩余金额
        // dp[i] 为凑成金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 凑成 0 金额 不需要硬币
        // 转移方程
        for (int i = 1; i <= amount; i++) {
            // 每个金额 尝试所有硬币
            for (int coin : coins) {
                // 有的减 && 这种选法可行
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
