package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/02/24
 * @Project: coding
 * @Description: 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 不允许使用除法
 */
public class Ques_238 {

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        // 计算左侧乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1]; // i左侧的乘积 不包括 i
        }
        // 计算右侧乘积 从右往左遍历
        int R = 1; // 初始右侧乘积为 1
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * R; // 左侧乘积 * 右侧乘积
            R = R * nums[i]; // 右侧乘积刷新
        }
        return answer;
    }


    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        // 计算左侧乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // 计算右侧乘积
        int rightProduct = 1; // 右侧乘积
        for (int i = n - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 rightProduct
            answer[i] *= rightProduct;
            // rightProduct 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 rightProduct 上
            rightProduct *= nums[i];
        }
        return answer;
    }
}
