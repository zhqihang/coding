package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/02/28
 * @Project: coding
 * @Description: 两数之和 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 */
public class Ques_167 {
    // 在数组中找到两个数，使得它们的和等于目标值，可以首先固定第一个数，然后寻找第二个数，第二个数等于目标值减去第一个数的差。
    // 利用数组的有序性质，可以通过二分查找的方法寻找第二个数。
    // 为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找。
    public int[] towSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    //初始时两个指针分别指向第一个元素位置和最后一个元素的位置。
    // 每次计算两个指针指向的两个元素之和，并和目标值比较。
    // 如果两个元素之和等于目标值，则发现了唯一解。
    // 如果两个元素之和小于目标值，则将左侧指针右移一位。
    // 如果两个元素之和大于目标值，则将右侧指针左移一位。
    // 移动指针之后，重复上述操作，直到找到答案。
    public int[] towSum1(int[] numbers, int target) {
        int slow = 0, fast = numbers.length - 1;
        while (slow < fast) {
            int sum = numbers[slow] + numbers[fast];
            if (sum > target) {
                fast--;
            } else if (sum < target) {
                slow++;
            } else {
                return new int[]{slow, fast};
            }
        }
        return null;
    }
}
