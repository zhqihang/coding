package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/10
 * @Project: coding
 * @Description: 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 思路: 双指针 维护可以收集的最大范围
 * 数组长度决定了范围 如果出现不符合条件的数字
 *
 */
public class Demo_041 {
    public int firstMissingPositive(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
                swap(arr, l, --r);
            } else {
                swap(arr, l, arr[l] - 1);
            }
        }
        return l + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
