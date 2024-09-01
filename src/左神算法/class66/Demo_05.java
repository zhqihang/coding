package 左神算法.class66;

/**
 * @description: 丑数
 * @author: zhqihang
 * @date: 2024/08/27
 * 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数
 * 丑数 就是只包含质因数 2、3 或 5 的正整数
 * 测试链接 : https://leetcode.cn/problems/ugly-number-ii/
 */
public class Demo_05 {
    // 当前丑数应是 比上一个丑数大 && 所有结果中较小的
    // 单调性
    public static int nthUglyNumber(int n) {
        // 定义三个指针 分别指向 x2 x3 x5 发现没用移动指针到下一个丑数
        // 丑数数组
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // i235对应三个指针所在下标 abc代表指针乘完预选的丑数
        for (int i = 2, i2 = 1, i3 = 1, i5 = 1, a, b, c; i <= n; i++) {
            // 计算预选的丑数
            a = dp[i2] * 2;
            b = dp[i3] * 3;
            c = dp[i5] * 5;
            // 选择当前丑数（所有预选中大于上一个丑数的最小的）
            dp[i] = Math.min(Math.min(a, b), c);
            // 移动失效指针
            if (dp[i] == a) i2++;
            if (dp[i] == b) i3++;
            if (dp[i] == c) i5++;
        }
        return dp[n];
    }
}
