package learn.class54;

/**
 * @Author: zhqihang
 * @Date: 2024/05/05
 * @Project: coding
 * @Description: 滑动窗口最大值（单调队列经典用法模版）
 */
public class Demo01 {
    // 数组实现队列
    public static int MAXN = 100001;
    public static int[] deque = new int[MAXN];
    public static int h, t;

    // 单调队列 存放数组下标 大到小
    // 维护一个长度为 k - 1 的窗口，每次入队一个元素，收集答案，出队一个元素
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 初始化队列
        h = t = 0;
        int n = nums.length;
        // 窗口初始化
        for (int i = 0; i < k - 1; i++) {
            // 从左往右 大到小
            // 队列非空 && 队尾元素小于当前元素
            while (h < t && nums[deque[t - 1]] <= nums[i]) {
                // 出队
                t--;
            }
            deque[t++] = i;
        }
        // 答案个数
        int m = n - k + 1;
        int[] ans = new int[m];
        // 遍历
        for (int l = 0, r = k - 1; l < m; l++, r++) {

            while (h < t && nums[deque[t - 1]] <= nums[r]) {
                t--;
            }
            deque[t++] = r;

            ans[l] = nums[deque[h]];

            if (deque[h] == l) {
                h++;
            }
        }
        return ans;
    }
}
