package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/03/03
 * @Project: coding
 * @Description: ...
 */
public class Ques_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        // 遍历数组
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum < target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
