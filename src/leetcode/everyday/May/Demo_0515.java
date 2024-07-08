package leetcode.everyday.May;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/15
 * @Project: coding
 * @Description: 完成所有任务的最少时间
 * <p>
 * 你有一台电脑，它可以 同时 运行无数个任务。
 * 给你一个二维整数数组 tasks，
 * 其中 tasks[i] = [start_i, end_i, duration_i] 表示
 * 第 i 个任务需要在 闭区间 时间段 [start_i, end_i] 内运行 duration_i 个整数时间点（但不需要连续）。
 * 当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。
 * 请你返回完成所有任务的情况下，电脑最少需要运行多少秒。
 * https://leetcode.cn/problems/minimum-time-to-complete-all-tasks/description
 * 输入：tasks = [[2,3,1],[4,5,1],[1,5,2]]
 * 输出：2
 * <p>
 * 我的思路: 我没有思路
 * <p>
 * 题解: 从右往左增加时间点
 * <p>
 * 方法一: 贪心 + 暴力
 * 方法二: 栈 + 二分查找
 */
public class Demo_0515 {
    public int findMinimumTime(int[][] tasks) {
        // 按照区间右端点进行排序
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int mx = tasks[tasks.length - 1][1];
        boolean[] run = new boolean[mx + 1]; // 时间点有无任务运行
        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int d = task[2];
            // 遍历 统计区间内的已有运行的时间点
            // 这个时间点可以再次利用 所以 d--
            for (int i = start; i <= end; i++) {
                if (run[i]) {
                    d--;
                }
            }
            // 尽量把时间点安排在靠后位置
            // 这样下一个区间就能尽可能的统计到更多的已有运行时间点
            for (int i = end; d > 0; i--) {
                if (!run[i]) {
                    run[i] = true; // 运行  实际运行是在这里
                    d--;
                    ans++; // 时长更新
                }
            }
        }
        return ans;
    }
}
