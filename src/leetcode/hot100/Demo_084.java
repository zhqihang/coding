package leetcode.hot100;

/**
 * @description: 寻找柱状图中的最大矩形
 * @author: zhqihang
 * @date: 2024/08/21
 */
public class Demo_084 {
    // 当前位置为高度 左右能扩展到哪里（宽度）
    // 寻找当前数左右第一个比自己小的 此时矩形面积等于 当前数 * 左右区间范围
    // 单调栈实现
    public static int MAXN = 100001;
    public static int r;
    public static int[] stack = new int[MAXN];

    public  int largestRectangleArea(int[] height) {
        int n = height.length;
        r = 0; // 初始化栈
        int ans = 0, cur, left;
        // 遍历每个数字计算矩形面积
        for (int i = 0; i < n; i++) {
            while (r > 0 && height[stack[r - 1]] >= height[i]) {
                cur = stack[--r];
                left = r == 0 ? -1 : stack[r - 1]; // 左边界
                // 计算高度
                ans = Math.max(ans, height[cur] * (i - left + 1));
            }
            stack[r++] = i;
        }
        while (r > 0) {
            cur = stack[--r];
            left = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, height[cur] * (n - left - 1));
        }
        return ans;
    }
}
