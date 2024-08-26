package leetcode.hot100;

/**
 * @description: 完全平方数
 * @author: zhqihang
 * @date: 2024/08/26
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * https://leetcode.cn/problems/perfect-squares/description
 */
public class Demo_279 {
    /*
    动态规划
     */
    public int numSquares(int n) {
        // f[i]表示和为i的完全平方数的最少数量
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            // 找到所有小于等于 i 的平方数 j*j
            for (int j = 1; j * j <= i; j++) {
                // 更新 minn 为 当前 minn 和  f[i - j*j] 的较小值
                minn = Math.min(minn, f[i - j * j]);
            }
            // 需要新增一个平方数
            f[i] = minn + 1;
        }
        return f[n];
    }
}
