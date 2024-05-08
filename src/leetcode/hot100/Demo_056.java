package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/08
 * @Project: coding
 * @Description: 合并区间
 * 以二维数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 思路:
 * 先按第一个维度(区间左边界)对区间进行排序
 * 然后逐个加入链表
 * 加入时判断 此区间的左边界 和 链表最后一个区间的右边界 是否重叠
 * 不重叠 加入链表 继续
 * 重叠 更新最后一个区间的右边界(取最大值--考虑区间包含) 不加入链表 继续
 *
 */
public class Demo_056 {

    public static int[][] merge(int[][] intervals) {
        // 按照第一个维度进行升序排序
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return o1[0] - o2[0];
        //     }
        // });
        Arrays.sort(intervals, (o1, o2) -> {return o1[0] - o2[0];});
        // 合并操作: 使用链表存储数组
        // 合并链表
        List<int[]> merge = new ArrayList<>();
        // 遍历数组中的区间
        for (int i = 0; i < intervals.length; i++) {
            // 区间左右边界
            int l = intervals[i][0];
            int r = intervals[i][1];
            // 如果合并链表为空 || 链表最后一组的右边界 小于 当前判断的 数组的左边界 (没有重叠)
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < l) {
                // 直接加入链表
                merge.add(new int[]{l, r});
            } else {
                // 合并操作 更新最后一组的右边界 不加入链表 继续开始下一组
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], r);
            }
        }
        return merge.toArray(new int[merge.size()][2]);
    }
}
