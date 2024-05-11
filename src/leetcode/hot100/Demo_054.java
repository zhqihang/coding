package leetcode.hot100;


import javax.swing.border.BevelBorder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/09
 * @Project: coding
 * @Description: 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 思路: 模拟螺旋操作
 */
public class Demo_054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 答案列表
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        // 定义四个边界
        int left = 0, right = matrix[0].length - 1, top = 0, bom = matrix.length - 1;
        while (true) {
            // 从左往右
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (++top > bom) break; // 上边界向下收缩

            // 从上往下
            for (int i = top; i <= bom; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) break; // 右边界向左收缩

            // 从右往左
            for (int i = right; i >= left; i--) {
                list.add(matrix[bom][i]);
            }
            if (--bom < top) break; // 下边界向上收缩

            // 从下往上
            for (int i = bom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return list;
    }
}
