package leetcode.everyday;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/05/14
 * @Project: coding
 * @Description: 完成所有任务的最少轮数
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。
 * 在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 * https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/description
 * <p>
 * 解题思路: 每次必须完成 2/3 个相同级别的难度
 * 相同难度任务的个数 使用哈希表统计
 * 贪心 每次尝试完成三个任务
 *
 */
public class Demo_0514 {
    public int minimumRounds(int[] tasks) {
        // 哈希表统计任务次数   难度:次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            // 存在返回旧值，不存在返回 null
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        // 开始遍历哈希表
        int ans = 0;
        for (Integer taskNum : map.values()) {
            if (taskNum == 1) {
                return -1;
            }
            // taskNum/3 向上取整  总的个数只有三种情况: 3的倍数 / 3的倍数+1 / 3的倍数+2
            ans += (taskNum + 2) / 3;
        }
        return ans;
    }
}
