package leetcode.everyday.May;

/**
 * @Author: zhqihang
 * @Date: 2024/05/31
 * @Project: coding
 * @Description: 找出缺失和重复的数字
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n^2] 范围内。
 * 除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 * https://leetcode.cn/problems/find-missing-and-repeated-values/description/
 * 输入：grid = [[1,3],[2,2]]
 * 输出：[2,4]
 */
public class Demo_0531 {

    // 位运算 奇数个数字的异或和相等
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int xorAll = 0;
        for (int[] ints : grid) {
            for (int i : ints) {
                xorAll ^= i;
            }
        }
        // xorALl 再 计算 1 ~ n^2 的异或和
        // n 为偶数时为 n^2  奇数时为 1
        xorAll ^= n % 2 > 0 ? 1 : n * n;

        int shift = Integer.numberOfTrailingZeros(xorAll);

        int[] ans = new int[2];

        for (int i = 1; i <= n * n; i++) {
            ans[i >> shift & 1] ^= i;
        }
        for (int[] row : grid) {
            for (int x : row) {
                ans[x >> shift & 1] ^= x;
            }
        }

        for (int[] row : grid) {
            for (int x : row) {
                if (x == ans[0]) {
                    return ans;
                }
            }
        }
        return new int[]{ans[1], ans[0]};
    }

    // 数组统计出现次数
    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n * n + 1];
        for (int[] ints : grid) {
            for (int i : ints) {
                arr[i]++; // 统计词频
            }
        }
        // 遍历数组
        int[] ans = new int[2];

        for (int i = 1; i <= n * n; i++) {
            if (arr[i] == 2) {
                ans[0] = i;
            }
            if (arr[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
