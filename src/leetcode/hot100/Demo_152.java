package leetcode.hot100;

/**
 * @description: 乘积最大子数组
 * @author: zhqihang
 * @date: 2024/09/03
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 */
public class Demo_152 {

    public int maxProduct1(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 暂存 因为更新需要互相依赖
            int curMax = maxProd;
            int curMin = minProd;
            // 更新 maxProd 和 minProd
            // 最大乘积 = 前一个最大乘积*当前数 || 当前数字本身 || 前一个最小乘积*当前数（负数的情况）
            maxProd = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            // 最小乘积 = 前一个最小乘积*当前数 || 当前数字本身 || 前一个最大乘积*当前数（负数的情况）
            minProd = Math.min(nums[i], Math.min(curMax * nums[i], curMin * nums[i]));
            // 更新 result
            result = Math.max(result, maxProd);
        }
        return result;
    }


    // 动态规划
    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF = new long[length]; // 到每个位置的最大乘积
        long[] minF = new long[length]; // 到每个位置的最小乘积
        // 初始化最大、最小乘积
        for (int i = 0; i < length; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }
        // 动态规划过程
        for (int i = 1; i < length; i++) {
            // 最大乘积 = 前一个最大乘积*当前数 || 当前数字本身 || 前一个最小乘积*当前数（负数的情况）
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            // 最小乘积 = 前一个最小乘积*当前数 || 当前数字本身 || 前一个最大乘积*当前数（负数的情况）
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            // 最小值溢出 重置
            if (minF[i] < (-1 << 31)) {
                minF[i] = nums[i];
            }
        }
        // 找到最大乘积
        int ans = (int) maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }
}
