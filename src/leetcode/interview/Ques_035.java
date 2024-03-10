package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/20
 * @Project: coding
 * @Description: 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 考虑到时间复杂度：二分查找
 */
public class Ques_035 {

    // 二分查找
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) << 1; // 右移一位 等于除以2
            // 如果中点是目标值 直接返回下标索引
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
