package leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhqihang
 * @Date: 2024/01/15
 * @Project: coding
 * @Description: 两数之和
 */
public class Ques_001 {
    public int[] twoSum(int[] nums, int target) {
        // 数组元素值：对应下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 值
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
