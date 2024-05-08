package leetcode.hot100;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/08
 * @Project: coding
 * @Description: 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 思路:
 * 尝试: 最大前缀和 减去 最小前缀和 但是  如果最大值在最小值的左边就算错了，例如 [1,-2]
 * 遍历数组计算前缀和，同时维护前缀和的最小值
 *
 * 前缀和 - min前缀和
 *
 */
public class Demo_053 {

    public int maxSubArray(int[] nums) {
        int sum = 0, minSum = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return ans;
    }

    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] arr = new int[n];
        int sum = 0, minSum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            arr[i] = sum;
            ans = Math.max(arr[i] - minSum, ans);
            minSum = Math.min(arr[i], minSum);
        }
        return ans;
    }
}
