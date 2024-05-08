package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/06
 * @Project: coding
 * @Description: 滑动窗口的最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 思路:
 * 递减单调队列实现  队列存放数组下标
 * 维护一个长度为 k - 1大小的窗口 每次入队一个元素 判断收集答案 出队一个元素
 *
 */
public class Demo_239 {
    // 数组 + 首位指针 实现队列
    public static int MAXN = 100001;
    public static int[] deque = new int[MAXN];
    public static int h, t;
    public int[] maxSlidingWindow(int[] nums, int k) {
        h = t = 0;
        int n = nums.length;
        // 维护窗口 0 ~ k-1
        for (int i = 0; i < k - 1; i++) {
            // 入队单调性判断
            while (h < t && nums[deque[t - 1]] <= nums[i]) {
                t--;
            }
            // 入队
            deque[t++] = i;
        }
        // 答案数组长度
        int m = n - k + 1;
        int[] ans = new int[m];
        // 遍历
        for (int l = 0, r = k - 1; l < m; l++, r++) {
            // 入队单调性判断
            while (h < t && nums[deque[t - 1]] <= nums[r]) {
                t--;
            }
            // 入队
            deque[t++] = r;
            // 收集答案
            ans[l] = nums[deque[h]];
            // 如果队头是 l 失效 出队
            if (deque[h] == l) {
                h++;
            }
        }
        return ans;
    }
}
