package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角
 * @author: zhqihang
 * @date: 2024/08/26
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Demo_118 {
    //
    public List<List<Integer>> generate(int numRows) {
        // 答案列表
        List<List<Integer>> ans = new ArrayList<>();
        // 循环每一行
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1); // 行首行尾
                else
                    // 行中 由上一行相加所得
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            ans.add(row);
        }
        return ans;
    }
}
