package 左神算法.class55;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/05
 * @Project: coding
 * @Description: 你可以安排的最多任务数目
 */
public class Demo03 {

    public static int[] tasks;

    public static int[] workers;

    public static int MAXN = 50001;

    public static int[] deque = new int[MAXN];

    public static int h, t;

    // 两个数组排序 : O(n * logn) + O(m * logm)
    // 二分答案的过程，每次二分都用一下双端队列 : O((n和m最小值)*log(n和m最小值))
    // 最复杂的反而是排序的过程了，所以时间复杂度O(n * logn) + O(m * logm)

    public int maxTaskAssign(int[] ts, int[] ws, int pills, int strength) {
        tasks = ts;
        workers = ws;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int tsize = tasks.length;
        int wsize = workers.length;
        int ans = 0;
        // [0, Math.min(tsize, wsize)]
        for (int l = 0, r = Math.min(tsize, wsize), m; l <= r; ) {
            // m中点，表示一定要完成的任务数量
            m = (l + r) / 2;
            // 任务选最小的   工人选最壮的
            if (f(0, m - 1, wsize - m, wsize - 1, strength, pills)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    // tasks[tl....tr]需要力量最小的几个任务
    // workers[wl....wr]力量值最大的几个工人
    // 药效是s，一共有的药pills个
    // 在药的数量不超情况下，能不能每个工人都做一个任务
    public static boolean f(int tl, int tr, int wl, int wr, int s, int pills) {
        h = t = 0;
        // 已经使用的药的数量
        int cnt = 0;
        for (int i = wl, j = tl; i <= wr; i++) {
            // i : 工人的编号
            // j : 任务的编号
            for (; j <= tr && tasks[j] <= workers[i]; j++) {
                // 工人不吃药的情况下，去解锁任务(能完成的任务)
                deque[t++] = j;
            }
            // 不吃药 做可以做的头部的最小数值的任务
            if (h < t && tasks[deque[h]] <= workers[i]) {
                h++;
            } else {
                // 吃药之后的逻辑  解锁任务(能完成的任务)
                for (; j <= tr && tasks[j] <= workers[i] + s; j++) {
                    deque[t++] = j;
                }
                // 有任务做
                if (h < t) {
                    cnt++;
                    t--; // 吃了药 从队尾的任务开始做 保证药丸不浪费
                } else {
                    // 吃了药还没有任务做 返回false
                    return false;
                }
            }
        }
        // 最省情况使用的药丸数小于给的药丸数 返回true
        return cnt <= pills;
    }
}
