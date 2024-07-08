package leetcode.everyday.May;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/26
 * @Project: coding
 * @Description: 找出第k大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值
 * 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * https://leetcode.cn/problems/find-kth-largest-xor-coordinate-value/description
 */
public class Demo_0526 {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] a = new int[m * n];
        int[][] s = new int[m + 1][n + 1];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                s[i + 1][j + 1] = s[i + 1][j] ^ s[i][j + 1] ^ s[i][j] ^ matrix[i][j];
                a[idx++] = s[i + 1][j + 1];
            }
        }
        Arrays.sort(a);
        return a[idx - k];
    }
}
