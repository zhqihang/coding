package leetcode.hot100;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 两数之和
 */
public class Demo_001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
