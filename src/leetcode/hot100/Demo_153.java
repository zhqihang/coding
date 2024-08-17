package leetcode.hot100;

/**
 * @description: 寻找旋转排序数组中的最小值
 * @author: zhqihang
 * @date: 2024/08/17
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description
 */
public class Demo_153 {

    public int findMin(int[] nums) {
        // 二分查找 但是两段有序 最小值在第一段的开头位置
        int n = nums.length;
        int left = 0, right =n - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                // mid 在第一段  最小值在 mid + 1 ~ right 之间
                left = mid + 1;
            } else {
                // mid 在第二段 继续二分
                right = mid;
            }
        }
        return nums[left];
    }
}
