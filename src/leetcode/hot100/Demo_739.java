package leetcode.hot100;

/**
 * @description: 每日温度
 * @author: zhqihang
 * @date: 2024/08/18
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * https://leetcode.cn/problems/daily-temperatures/description/
 */
public class Demo_739 {
    // 左神算法课 52节 单调栈-上
    public static int MAXN = 100001;
    // 数组 + 指针 实现栈
    public static int[] stack = new int[MAXN];
    public int r;
    // 单调栈（小压大）
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n]; // 答案数组
        // 初始化栈 栈中存储 数组下标
        int r = 0;
        for (int i = 0, cur; i < n; i++) {
            // while 循环维护单调递减栈
            // 栈非空 && 栈顶元素对应温度值 小于当前元素
            // 此时栈中这些日期 i 遇到更高的温度了 需要弹出
            while (r > 0 && temperatures[stack[r - 1]] < temperatures[i]) {
                cur = stack[--r];
                ans[cur] = i - cur; // 记录答案
            }
            // 栈空 || 栈顶元素不小于当前元素
            stack[r++] = i;
        }
        return ans;
    }
}
