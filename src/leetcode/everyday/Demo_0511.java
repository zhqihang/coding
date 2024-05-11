package leetcode.everyday;

/**
 * @Author: zhqihang
 * @Date: 2024/05/11
 * @Project: coding
 * @Description: 收集垃圾的最少总时间
 * https://leetcode.cn/problems/minimum-amount-of-time-to-collect-garbage/?envType=daily-question&envId=2024-05-11
 *
 * 给你一个下标从 0 开始的字符串数组 garbage ，其中 garbage[i] 表示第 i 个房子的垃圾集合。
 * garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。
 * 垃圾车收拾 一 单位的任何一种垃圾都需要花费 1 分钟。
 * 同时给你一个下标从 0 开始的整数数组 travel ，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数。
 * 城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0 出发，按顺序 到达每一栋房子。但它们 不是必须 到达所有的房子。
 * 任何时刻只有 一辆 垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能 做任何事情。
 * 请你返回收拾完所有垃圾需要花费的 最少 总分钟数。
 *
 * 解题思路: 让所有垃圾车都跑完全程 再倒着遍历 减去多跑的时间
 * 三次遍历 分别收集三种垃圾
 * 用时 = 收集垃圾用时 + 行驶用时
 *
 */
public class Demo_0511 {
    // 三次遍历
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        // 收集垃圾用时
        for (String g : garbage) {
            ans += g.length();
        }
        // 跑三次全程的时间
        for (int t : travel) {
            ans += t * 3;
        }
        // 针对三种垃圾
        for (char c : new char[]{'M', 'P', 'G'}) {
            // 从后往前遍历 如果没有          indexOf返回第一次出现的索引 如果不存在 返回 -1
            for (int i = garbage.length - 1; i > 0 && garbage[i].indexOf(c) < 0; i--) {
                // 没有垃圾c 多跑了
                ans -= travel[i - 1];
            }
        }
        return ans;
    }
}
