package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description: 数组中的第k个最大元素
 * @author: zhqihang
 * @date: 2024/08/18
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 */
public class Demo_215 {

    // 无序数组  时间复杂度O(n) 所以不能排序再找
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

     // 快速选择算法
    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size())); // 基准数

        // 根据基准数划分将数组元素三个部分
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (Integer num : nums) {
            if (num > pivot) big.add(num);
            else if (num == pivot) equal.add(num);
            else small.add(num);
        }
        // 判断第k大的元素在哪个集合
        if (k <= big.size())
            return quickSelect(big, k); // 答案在大于部分
        if (k > nums.size() - small.size())
            // 答案在小于部分（延伸出了 equal & big）
            return quickSelect(small, k - nums.size() + small.size());
        return pivot; // 递归出口
    }
}
