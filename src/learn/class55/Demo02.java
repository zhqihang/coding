package learn.class55;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 满足不等式的最大值
 */
public class Demo02 {
    public static int MAXN = 100001;
    public static int[][] deque = new int[MAXN][2];
    public static int h, t;

    public int findMaxValueOfEquation(int[][] points, int k) {
        h = t = 0;
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0, x, y; i < n; i++) {
            x = points[i][0];
            y = points[i][1];
            // 出队
            while (h < t && deque[h][0] + k < x) {
                h++;
            }
            // 记录答案
            if (h < t) {
                ans = Math.max(ans, x + y + deque[h][1] - deque[h][0]);
            }
            // 入队准备
            while (h < t && deque[t - 1][1] - deque[t - 1][0] <= y - x) {
                t--;
            }
            // 入队
            deque[t][0] = x;
            deque[t++][1] = y;
        }
        return ans;
    }
}
