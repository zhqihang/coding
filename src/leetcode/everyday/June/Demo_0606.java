package leetcode.everyday.June;

/**
 * @Author: zhqihang
 * @Date: 2024/06/06
 * @Project: coding
 * @Description: 区分黑球和白球
 * 桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
 * 给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
 * 在每一步中，你可以选择两个相邻的球并交换它们。
 * 返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
 * <p>
 * https://leetcode.cn/problems/separate-black-and-white-balls/description/
 */
public class Demo_0606 {
    public long minimumSteps(String s) {
        char[] chars = s.toCharArray();
        long ans = 0;
        int cnt1 = 0;
        for (char ch : chars) {
            // 如果是 1 统计个数
            if (ch == '1') {
                cnt1++;
            } else {
                // 如果是 0 增加交换次数
                // 和左侧的 所有 1 (cnt1) 进行交换
                ans += cnt1;
            }
        }
        return ans;
    }
}
