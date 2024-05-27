package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/26
 * @Project: coding
 * @Description: 搜索二维矩阵2
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：
 * - 每行的元素从左到右升序排列。
 * - 每列的元素从上到下升序排列。
 */
public class Demo_240 {

    // 二维矩阵中查找 目标值
    // 利用有序的特性进行优化: 每次从右上角开始找
    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分查找
        int m = matrix.length;
        int n = matrix[0].length;
        // 右上角坐标
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 第 i 行的数字都小于 target 全部排除
                i++;
            } else {
                // 第 j 列的数字都大于 target 全部排除
                j--;
            }
        }
        return false;
    }
}
