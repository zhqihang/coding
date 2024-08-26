package leetcode.hot100;

/**
 * @description: 爬楼梯
 * @author: zhqihang
 * @date: 2024/08/26
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * https://leetcode.cn/problems/climbing-stairs/description/
 */
public class Demo_070 {
    // 动态规划
    // 前面每一步决定后面的选择
    public int climbStairs(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n - 1; i++) {
            sum = a + b;
            a  = b;
            b = sum;
        }
        return b;
    }

    public int climbStairs1(int n) {
        if (n == 1 || n == 2) return n;
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
