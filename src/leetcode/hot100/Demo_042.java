package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/06
 * @Project: coding
 * @Description: 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 *
 */
public class Demo_042 {
    // 双指针优化遍历
    public int trap(int[] height) {
        int n = height.length;
        int l = 1, r = n - 2, lmax = height[0], rmax = height[n - 1];
        int ans = 0;
        while (l <= r) {
            if (lmax < rmax) {
                // 结算左指针水量
                ans += Math.max(0, lmax - height[l]);
                // 更新左侧最大值
                lmax = Math.max(lmax, height[l++]);
            } else {
                // 结算右指针水量
                ans += Math.max(0, rmax - height[r]);
                // 更新右侧最大值
                rmax = Math.max(rmax, rmax - height[r--]);
            }
        }
        return ans;
    }
}
