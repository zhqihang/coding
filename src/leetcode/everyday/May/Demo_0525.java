package leetcode.everyday.May;

/**
 * @Author: zhqihang
 * @Date: 2024/05/25
 * @Project: coding
 * @Description: 找出满足差值条件的下标
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums，以及整数 indexDifference 和整数 valueDifference 。
 * 你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：
 * - abs(i - j) >= indexDifference 且
 * - abs(nums[i] - nums[j]) >= valueDifference
 * 返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；
 * 否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。
 * <p>
 * https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/description
 * <p>
 * 输入：nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
 * 输出：[0,3]
 */
public class Demo_0525 {
    // 双指针 + 维护最大最小
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIdx = 0;
        int minIdx = 0;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            } else if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[maxIdx] - nums[j] >= valueDifference) {
                return new int[]{maxIdx, j};
            }
            if (nums[j] - nums[minIdx] >= valueDifference) {
                return new int[]{minIdx, j};
            }
        }
        return new int[]{-1, 1};
    }
}
