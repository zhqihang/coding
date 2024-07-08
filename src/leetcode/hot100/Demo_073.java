package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/07
 * @Project: coding
 * @Description: 矩阵置0 (七牛云笔试题)
 */
public class Demo_073 {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr);
    }

    public static void setZeroes(int[][] matrix) {
        // m 行 n 列
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0 = false, row0 = false;

        // 第一列 更新标记
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
        }

        // 第一行 更新标记
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
            }
        }

        // 第一行 第一列 被 影响到的位置 置 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 第一行 第一列 处理 其他位置 置 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 根据标志位 如果为真 则置0
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
