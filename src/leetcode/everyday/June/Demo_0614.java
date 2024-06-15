package leetcode.everyday.June;

/**
 * @Author: zhqihang
 * @Date: 2024/06/14
 * @Project: coding
 * @Description: 访问数组中的位置 使得分数最大
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。
 * 你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：
 *  - 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。(右移)
 *  - 对于你访问的位置 i ，你可以获得分数 nums[i] 。
 *  - 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
 * 请你返回你能得到的 最大 得分之和。
 * 注意 ，你一开始的分数为 nums[0] 。
 * https://leetcode.cn/problems/visit-array-positions-to-maximize-score/description/
 *
 * 输入：nums = [2,3,6,1,9,2], x = 5
 * 输出：13
 *
 * 右移 两者奇偶性相同 获得分数
 * 动态规划
 * 寻找重叠子问题
 */
public class Demo_0614 {

    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] f = new long[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            int v = nums[i];
            int r = v % 2;
            f[i][r ^ 1] = f[i + 1][r ^ 1];
            f[i][r] = Math.max(f[i + 1][r], f[i + 1][r ^ 1] - x) + v;
        }
        return f[0][nums[0] % 2];
    }
}
