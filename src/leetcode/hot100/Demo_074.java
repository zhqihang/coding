package leetcode.hot100;

/**
 * @description: 搜索二维矩阵
 * @author: zhqihang
 * @date: 2024/08/17
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 */
public class Demo_074 {
    // 思路 按行来看整个是递增的序列 递增序列 -- 二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        // 二分查找（a[i] 转化为 行号和列号）
        int left = -1;
        int right = m * n;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int x = matrix[mid / n][mid % n]; // 一维数组 -- 行号列号转化
            if (x == target) return true;
            if (x < target) left = mid;
            if (x > target) right = mid;
        }
        return false;
    }
}
