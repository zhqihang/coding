package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/31
 * @Project: coding
 * @Description: 买卖股票时机2
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 */
public class Ques_122 {
    public int maxProfit(int[] price) {
        // 贪心：如果明天比今天贵 则今天买入 明天卖出
        // 利润
        int profit = 0;
        int len = price.length;
        for (int i = 1; i < len; i++) {
            profit += Math.max(0, price[i] - price[i - 1]);
        }
        return profit;
    }
}
