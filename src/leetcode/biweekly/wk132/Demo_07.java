package leetcode.biweekly.wk132;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/06/09
 * @Project: coding
 * @Description: 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
 * 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
 * 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
 * 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
 * 以整数形式返回执行最优操作能够获得的 最大 总奖励。
 * https://leetcode.cn/contest/weekly-contest-401/problems/maximum-total-reward-using-operations-i/description/
 */
public class Demo_07 {
    public static int MAX_N = 2001;
    public static int[] queue = new int[MAX_N];
    public static int left, right;

    public static int maxTotalReward(int[] rewardValues) {
        // 初始化优先队列
        left = right = 0;
        int sum = 0;
        Arrays.sort(rewardValues);
        for (int reward : rewardValues) {
            if (reward > sum) {
                sum += reward;
                queue[right++] = reward;
            } else {
                if (queue[left] == reward) {
                    continue;
                } else if (left != right && queue[left] < reward) {
                    if (reward > sum - queue[left]) {
                        sum -= queue[left++];
                        sum += reward;
                        queue[right++] = reward;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] rewardValues = {1, 6, 4, 3, 2};
        System.out.println(maxTotalReward(rewardValues));
    }
}
