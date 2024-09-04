package leetcode.hot100;

/**
 * @description: 分割等和子集
 * @author: zhqihang
 * @date: 2024/09/03
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class Demo_416 {

    // 动态规划
    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        // 数组元素和 偶数才可以划分
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        // 问题转化为是否存在一个子集 元素和为 sum/2
        int target = sum / 2;
        // dp[i] 表示 是否可以从 nums 数组中挑选出来一些数字，使得和正好为 i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        // 状态转移
        // 遍历数组中的每个数字
        for (int num : nums) {
            // 更新 dp[nums] ~ dp[target] 的状态
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}
