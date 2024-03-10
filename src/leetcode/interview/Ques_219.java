package leetcode.interview;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/01/15
 * @Project: coding
 * @Description: 给你一个整数数组 nums 和一个整数 k ，
 * 判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class Ques_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // value : index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
