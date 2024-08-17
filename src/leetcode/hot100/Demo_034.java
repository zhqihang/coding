package leetcode.hot100;

/**
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: zhqihang
 * @date: 2024/08/17
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class Demo_034 {
    // 二分查找 缩小范围
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        // 如果start存在 end必然存在
        int end = lowerBound(nums, target + 1) -1; // 右边界
        return new int[]{start, end};
    }

    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left;
    }
}
