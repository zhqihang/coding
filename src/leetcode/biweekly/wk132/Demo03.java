package leetcode.biweekly.wk132;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: zhqihang
 * @Date: 2024/06/08
 * @Project: coding
 * @Description: ...
 *
 * https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/
 */
public class Demo03 {

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] 表示前 i 个元素中，以 nums[i] 结尾，并且相邻元素不同的次数为 j 的最长子序列长度
        int[][] dp = new int[n][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, 1); // 初始化每个 dp 值为 1，因为每个元素自己本身可以构成一个长度为 1 的子序列
        }

        int result = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int diff = 0; diff <= k; diff++) {
                    if (nums[i] == nums[j]) {
                        dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                    } else if (diff < k) {
                        dp[i][diff + 1] = Math.max(dp[i][diff + 1], dp[j][diff] + 1);
                    }
                }
            }

            for (int diff = 0; diff <= k; diff++) {
                result = Math.max(result, dp[i][diff]);
            }
        }

        return result;
    }
}
