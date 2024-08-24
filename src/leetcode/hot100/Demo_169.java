package leetcode.hot100;

import java.util.Arrays;

/**
 * @description: 多数元素
 * @author: zhqihang
 * @date: 2024/08/24
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Demo_169 {

    /*
    摩尔投票法（核心是正负票数抵消）：
        推论一：若记 众数 的票数为 +1 ，非众数的票数为 −1，则一定有所有数字的票数和 >0 。
        推论二：若数组的前 a 个数字的票数和 = 0，则数组剩余 (n−a) 个数字的票数和一定仍 >0，
                即后 (n−a) 个数字的 众数仍为 x 。

    初始化：票数统计 votes = 0，众数 x。
    循环：遍历数组 nums 中的每个数字 num 。
        当票数 votes 等于 0，则假设当前数字 num 是众数。
        当 num = x 时，票数 votes 自增 1；当 num != x 时，票数 votes 自减 1 。
    返回值：返回 x 即可
    */
    public int majorityElement(int[] nums) {
        int votes = 0, x = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            if (num == x) votes++;
            if (num != x) votes--;
        }
        return x;
    }

    // 排序后 下标为 n/2 的数一定是众数
    // 时间复杂度 nlogn
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
