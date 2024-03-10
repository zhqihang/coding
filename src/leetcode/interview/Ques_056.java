package leetcode.interview;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/01/15
 * @Project: coding
 * @Description: 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * <p>
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Ques_056 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 6}, {8, 10}, {11, 18}};
        int[][] merge = merge1(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.println(); // 换行
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 对区间按照起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                // 合并重叠区间
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // 无重叠，添加当前区间到结果集，并更新当前区间为下一个区间
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // 添加最后一个合并后的区间
        result.add(currentInterval);

        // 转换List为数组
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] merge1(int[][] intervals) {
        // intervals 按照第一维度升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // 1-2 升序  2-1降序
            }
        });

        ArrayList<int[]> merge = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];

            // 1. 此区间的前一个区间的右边界 小于 左边界  没有重叠部分
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < l) {
                // 不进行合并操作 直接加入merge
                merge.add(new int[]{l, r});
            } else {
                // 有重叠部分 二合一
                // 比较 更新上一个区间的 右边界 进行合并   取最大值是因为 存在 ： {[8,20] [9,10]}  --> {[8,20]}
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], r);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
