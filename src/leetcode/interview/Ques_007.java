package leetcode.interview;

/**
 * @author: qihang
 * @CreateDate: 2023/12/22/ 15:03
 * @Project: coding
 * @Description: ......
 */
public class Ques_007 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("maxProfit(prices) = " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0; // 不持股的现金数
        dp[0][1] = -prices[0]; // 持股的现金数

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
