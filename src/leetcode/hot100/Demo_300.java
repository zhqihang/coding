package leetcode.hot100;

import java.util.Arrays;

/**
 * @description: 最长递增子序列
 * @author: zhqihang
 * @date: 2024/09/03
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * https://leetcode.cn/problems/longest-increasing-subsequence/description
 */
public class Demo_300 {

    // 空间优化
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int len = 0; // 记录当前最长递增子序列的长度
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1); // 如果num比dp中所有元素都大，找到第一个比num大的位置
            }
            dp[i] = num; // 更新dp数组
            if (i == len) {
                len++; // 如果num扩展了序列，增加长度
            }
        }
        return len; // 返回最长递增子序列的长度
    }

    // 动态规划
    // 最长的 严格递增的 子序列 的长度
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        // dp[i] 表示 i位置前递增子序列的长度
        int[] dp = new int[length];
        int maxLength = 0;
        // 遍历每个位置 计算长度
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            // 转移方程
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 更新 dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
