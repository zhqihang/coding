package learn.class54;

/**
 * @Author: zhqihang
 * @Date: 2024/05/05
 * @Project: coding
 * @Description: ...
 */
public class Demo02 {
    // 两个单调队列 分别维护窗口最大值和最小值
    public static int MAXN = 100001;
    public static int[] maxDeque = new int[MAXN];
    public static int[] minDeque = new int[MAXN];
    public static int maxH, maxT, minH, minT;

    public static int[] arr;

    public int longestSubarray(int[] nums, int limit) {
        maxH = maxT = minH = minT = 0;
        arr = nums;
        int n = arr.length;
        int ans = 0;
        for (int l = 0, r = 0; l < n; l++) {
            // 窗口左闭右开[l, r)
            // 下一个数能不能进入这个窗口
            // r 代表 没有进入窗口的下一个数的位置
            while (r < n && ok(limit, nums[r])) {
                push(r++); // 达标 进入窗口  更新最大值和最小值
            }
            // l --> r 是 l 开头的向右延伸的最长的子数组
            ans = Math.max(ans, r - l);
            // l 需要弹出 pop更新最值结构
            pop(l);
        }
        return ans;
    }

    // num进入后 是否满足绝对差不超过限制
    public static boolean ok(int limit, int num) {
        // max 如果num进入 新窗口的最大值
        //                    ?                      有值PK出最大值 : 窗口为空
        int max = maxH < maxT ? Math.max(arr[maxDeque[maxH]], num) : num;
        int min = minH < minT ? Math.min(arr[minDeque[minH]], num) : num;
        return max - min <= limit;
    }

    // r 位置的数组加入窗口 更新最值
    public static void push(int r) {
        // 更新最值单调队列
        // 移除比它小的
        while (maxH < maxT && arr[maxDeque[maxT - 1]] <= arr[r]) {
            maxT--;
        }
        // 入队
        maxDeque[maxT++] = r;
        // 移除比它打的
        while (minH < minT && arr[minDeque[minT - 1]] >= arr[r]) {
            minT--;
        }
        // 入队
        minDeque[minT++] = r;
    }

    // 窗口吐出 l 位置  更新最值结构
    public static void pop(int l) {
        if (maxH < maxT && maxDeque[maxH] == l) {
            maxH++;
        }
        if (minH < minT && minDeque[minH] == l) {
            minH++;
        }
    }
}
