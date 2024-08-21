package leetcode.hot100;

/**
 * @description: 寻找两个正序数组的中位数
 * @author: zhqihang
 * @date: 2024/08/18
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 */
public class Demo_004 {
    /*
    两个正序有序数组 拼接之后的 中位数：
    根据中位数的定义：
        当 m+n 是奇数时，中位数是两个有序数组中的第 (m+n)/2 个元素，
        当 m+n 是偶数时，中位数是两个有序数组中的第 (m+n)/2 个元素和第 (m+n)/2+1 个元素的平均值。
    这道题可以转化成寻找两个有序数组中的第 k 小的数，其中 k 为 (m+n)/2 或 (m+n)/2+1。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 数组合并后的 第 k 小的值
        int ans1 = getKthMin(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (nums1.length + nums2.length + 1) / 2);
        // 数组合并后的 第 k+1 小的值
        int ans2 = getKthMin(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (nums1.length + nums2.length + 2) / 2);
        /*
        如果合并之后 数组长度为奇数 那么中位数就是 ans1, 数组长度为偶数 那么中位数就是 ans1 ans2 的平均值
        如果为奇数时， (nums1.length + nums2.length + 1) / 2 == (nums1.length + nums2.length + 2) / 2
        所以最后的返回值都是 (ans1 + ans2) / 2.0
         */
        return (ans1 + ans2) / 2.0;
    }

    // 递归函数 获取两个数组合并后的 第 k 小的值
    private int getKthMin(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // 长度
        int size1 = end1 - start1 + 1;
        int size2 = end2 - start2 + 1;

        // 交换数组
        // 设定nums1的长度严格小于等于 nums2
        if (size1 > size2) return getKthMin(nums2, start2, end2, nums1, start1, end1, k);

        // 处理边界情况
        // 当nums1排空之后，此时 只需要取nums的第k个，即为第k小的元素
        if (size1 == 0) return nums2[start2 + k - 1];
        // 取第一小的元素 只需要比较两个递增有序数组的首个元素即可
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 递归二分查找
        // 选择两个数组的中间位置 pos1 pos2
        int pos1 = start1 + Math.min(size1, k / 2) - 1;
        int pos2 = start2 + Math.min(size2, k / 2) - 1;
        if (nums1[pos1] > nums2[pos2]) {
            // 排除第二个数组不符合条件的数字
            return getKthMin(nums1, start1, end1, nums2, pos2 + 1, end2, k - (pos2 - start2 + 1));
        } else {
            // 排除第一个数组不符合条件的数字
            return getKthMin(nums1, pos1 + 1, end1, nums2, start2, end2, k - (pos1 - start1 + 1));
        }
    }
}
