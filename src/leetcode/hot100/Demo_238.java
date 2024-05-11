package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/09
 * @Project: coding
 * @Description: 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 思路: 每个位置计算左右侧乘积 移动则进行刷新
 */
public class Demo_238 {

    //
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 答案数组
        int[] ans = new int[n];
        // 计算左侧乘积 前缀数组
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // 计算右侧乘积 从右往左遍历
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        return ans;
    }
}
