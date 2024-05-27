package leetcode.hot100;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/27
 * @Project: coding
 * @Description: 分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * - 每个孩子至少分配到 1 个糖果。
 * - 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * https://leetcode.cn/problems/candy
 */
public class Demo_135 {

    // 两次遍历
    // 先给所有孩子一颗糖
    // 左遍历: 如果 i 比 i-1 大, i 多一颗 其他情况交给右遍历处理
    // 右遍历: 如果 i-1 比 i 大, i-1 多一颗
    // 取两次的最大值
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        // 左遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1; // 左规则
            }
        }
        // 最右侧 只需要满足左规则即可 直接统计
        int ans = left[ratings.length - 1];
        // 右遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1; // 右规则
            }
            // 顺带统计答案
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}