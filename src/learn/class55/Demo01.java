package learn.class55;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 和为 k 的最短子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，
 * 找出 nums 中和至少为 k 的 最短非空子数组 ，
 * 并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 * <p>
 * 子数组 是数组中 连续 的一部分。
 */
public class Demo01 {
    // 单调队列  小 --> 大
    // 存储 前缀和的数组下标
    // 当前位置向左延伸多短 可以达标
    public static int MAXN = 100001;
    public static int[] deque = new int[MAXN];
    public static int h, t;
    // 前缀和数组
    // sum[0] : 前0个数的前缀和
    // sum[i] : 前i个数的前缀和
    public static long[] sum = new long[MAXN];

    public int shortestSubarray(int[] arr, int k) {
        int n = arr.length;
        // 处理前缀和数组 (sum[0] = 0)
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }

        h = t = 0;
        int ans = Integer.MAX_VALUE;
        // 处理 i 位置的数的前缀和
        for (int i = 0; i <= n; i++) {
            // 队列中存在可能性 && 当前前缀和 - 头部前缀和 >= k 则达标
            while (h != t && sum[i] - sum[deque[h]] >= k) {
                // 计算结果 出队
                ans = Math.min(ans, i - deque[h++]);
            }
            // 前 i 个数的前缀和 入队
            // 维持 小 --> 大  如果存在大于的 弹出
            while (h != t && sum[deque[t - 1]] >= sum[i]) {
                t--;
            }
            // 入队
            deque[t++] = i;
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
