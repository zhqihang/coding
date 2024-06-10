package leetcode.everyday.June;

/**
 * @Author: zhqihang
 * @Date: 2024/06/09
 * @Project: coding
 * @Description: 戳气球
 *
 * 有 n 个气球，编号为 0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。
 * 戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。
 * 如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 * https://leetcode.cn/problems/burst-balloons/description
 *
 */
public class Demo_0609 {
    // dp[i][j] 表示填满开区间(i, j)能得到的最多硬币数
    // 边界条件为 i >= j - 1 有 dp[i][j] = 0
    // 状态转移方程
    // dp[i][j] = val[i] * val[k] * val[j] + dp[i][k] + dp[k][j]  此时 i < j- 1
    // return dp[0][n + 1]
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }
}
