package leetcode.biweekly.wk131;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/05/25
 * @Project: coding
 * @Description: 求出出现两次数字的 XOOR值
 *
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
 * 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 */
public class Demo01 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(duplicateNumbersXOR(nums));
    }
    public static int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                ans ^= num;
            } else {
                set.add(num);
            }
        }
        return ans;
    }
}
