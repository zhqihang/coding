package leetcode.hot100;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/05/06
 * @Project: coding
 * @Description: 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列
 */
public class Demo_560 {
    public int subarraySum(int[] nums, int k) {
        // 前缀和 ：出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            // 0 -- i 的前缀和 减去 k 如果出现过 证明中间有数组和是 k
            ans += map.getOrDefault(sum - k, 0); // 更新答案
            map.put(sum, map.getOrDefault(sum, 0) + 1); // 更新前缀和出现次数
        }
        return ans;
    }
}
