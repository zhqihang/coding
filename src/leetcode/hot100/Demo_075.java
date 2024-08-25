package leetcode.hot100;

import java.util.Arrays;

/**
 * @description: 颜色分类
 * @author: zhqihang
 * @date: 2024/08/25
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class Demo_075 {
    /*
    两次遍历：第一次把 0 交换到数组头部
             第二次把 1 交换到数组头部
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int r = 0; // 头部边界指针
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) swapXOR(nums, r++, i);
        }
        // 第二次遍历
        for (int i = r; i < n; i++) {
            if (nums[i] == 1) swapXOR(nums, r++, i);
        }
    }

    // 交换数组两个位置的元素
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 当a和b相等时，该方法不适用
    private void swapXOR(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];

    }
}
