package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/31
 * @Project: coding
 * @Description: 跳跃游戏1
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class Ques_055 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 最远可以到达的位置
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            // 如果i可以达到
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                // 如果最远可以到达的位置大于等于数组中的最后一个位置,直接返回true
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
