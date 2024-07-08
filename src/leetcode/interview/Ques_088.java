package leetcode.interview;

import java.util.Arrays;

/**
 * @author: qihang
 * @CreateDate: 2023/11/23/ 21:12
 * @Project: coding
 * @Description: 力扣面试经典题第88道
 */
public class Ques_088 {

    /*
    给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
       请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
       注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
       为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
       nums2 的长度为 n 。
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        // merge1(nums1, 3, nums2, 3);
        merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    //双指针
    //我们用两个指针 i 和 j 分别指向两个数组的末尾，用一个指针 k 指向合并后的数组的末尾。
    // 每次比较两个数组的末尾元素，将较大的元素放在合并后的数组的末尾，然后将指针向前移动一位，
    // 重复这个过程，直到两个数组的指针都指向了数组的开头。
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; j >= 0; k--) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    // 方法一 直接合并之后进行排序
    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 合并两个数组
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        //对nums1进行排序
        Arrays.sort(nums1);
    }
}
