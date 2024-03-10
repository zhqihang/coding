package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/24
 * @Project: coding
 * @Description: x的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class Ques_069 {
    // x 搜索所有可能的整数
    // 存在开方不是整数的整数？

    // 牛顿迭代  y = f(x) = x^2 − C
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    // 二分查找
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        // 二分查找
        while (l <= r) {
            // 中点
            int mid = l + ((r - l) >> 2);
            // 如果中点的平方小于等于 x
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // 袖珍计算器算法
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        // 相乘有溢出风险
        return (long) (ans + 1) * (ans + 1) > x ? ans : ans + 1;
    }
}
