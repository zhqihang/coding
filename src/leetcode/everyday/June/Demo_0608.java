package leetcode.everyday.June;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/06/08
 * @Project: coding
 * @Description: 相同分数的最大操作数目 2
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
 * - 选择 nums 中最前面两个元素并且删除它们。
 * - 选择 nums 中最后两个元素并且删除它们。
 * - 选择 nums 中第一个和最后一个元素并且删除它们。
 * 一次操作的 分数 是被删除元素的和。
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 * https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/
 * <p>
 * 解题思路:
 * 无论第一步做哪种操作 操作完成后都是一个 连续子数组 是规模更小的 子问题
 * 子数组的左右端点表示状态 状态的值就是这个子数组的操作次数
 * <p>
 * 当发现子问题的值是从两侧向内缩小的就可以考虑 区间dp
 * 确定了第一步是哪个操作(删除元素之和) 决定了后续操作
 * 三种操作对应三种不同元素和 用三次 区间dp 解决
 * <p>
 * 优化1 : 答案次数最大是n/2
 */
public class Demo_0608 {
    private int[] nums;
    private int[][] memo;

    private boolean done;

    public int maxOperations1(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new int[n][n];
        // 初始化记忆数组
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 三个区间dp
        int res1 = dfs(2, n - 1, nums[0] + nums[1]); // 删除前两个
        int res2 = dfs(0, n - 3, nums[n - 2] + nums[n - 1]); // 删除后两个
        int res3 = dfs(1, n - 2, nums[0] + nums[n - 1]); // 前后各删除一个
        // 返回最大结果 + 第一次选择的次数
        return Math.max(Math.max(res1, res2), res3) + 1;
    }

    private int dfs(int i, int j, int target) {
        if (done) return 0;
        if (i >= j) {
            done = true;
            return 0;
        }
        if (memo[i][j] != -1) return memo[i][j];
        int res = 0;
        // 删除前两个数
        if (nums[i] + nums[i + 1] == target)
            res = Math.max(res, dfs(i + 2, j, target) + 1);
        // 删除后两个数
        if (nums[j - 1] + nums[j] == target)
            res = Math.max(res, dfs(i, j - 2, target) + 1);
        // 前后各删除一个数
        if (nums[i] + nums[j] == target)
            res = Math.max(res, dfs(i + 1, j - 1, target) + 1);
        return memo[i][j] = res;
    }


    // 翻译为递推
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int res1 = helper(nums, 2, n - 1, nums[0] + nums[1]); // 删除前两个
        int res2 = helper(nums, 0, n - 3, nums[n - 2] + nums[n - 1]); // 删除后两个
        int res3 = helper(nums, 1, n - 2, nums[0] + nums[n - 1]); // 前后各删除一个
        return Math.max(Math.max(res1, res2), res3) + 1;
    }

    private int helper(int[] nums, int start, int end, int target) {
        int n = nums.length;
        int[][] f = new int[n + 1][n + 1];
        for (int i = end - 1; i >= start; i--) {
            for (int j = i + 1; j <= end; j++) {
                if (nums[i] + nums[i + 1] == target) { // 删除前两个数
                    f[i][j + 1] = Math.max(f[i][j + 1], f[i + 2][j + 1] + 1);
                }
                if (nums[j - 1] + nums[j] == target) { // 删除后两个数
                    f[i][j + 1] = Math.max(f[i][j + 1], f[i][j - 1] + 1);
                }
                if (nums[i] + nums[j] == target) { // 删除第一个和最后一个数
                    f[i][j + 1] = Math.max(f[i][j + 1], f[i + 1][j] + 1);
                }
            }
        }
        return f[start][end + 1];
    }
}
