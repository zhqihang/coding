package 左神算法.class33;

// 不用任何算术运算，只用位运算实现加减乘除
// 代码实现中你找不到任何一个算术运算符
// 测试链接 : https://leetcode.cn/problems/divide-two-integers/
public class BitOperationAddMinusMultiplyDivide {

    public static int MIN = Integer.MIN_VALUE;

    // 除法
    public static int divide(int a, int b) {
        if (a == MIN && b == MIN) {
            // a和b都是整数最小
            return 1;
        }
        if (a != MIN && b != MIN) {
            // a和b都不是整数最小，那么正常去除
            return div(a, b);
        }
        if (b == MIN) {
            // a不是整数最小，b是整数最小
            return 0;
        }
        // a是整数最小，b是-1，返回整数最大，因为题目里明确这么说了
        if (b == neg(1)) {
            return Integer.MAX_VALUE;
        }
        // a是整数最小，b不是整数最小，b也不是-1
        // div(a + b, b) - 1
        a = add(a, b > 0 ? b : neg(b));
        int ans = div(a, b);
        int offset = b > 0 ? neg(1) : 1;
        return add(ans, offset);
    }

    // 必须保证a和b都不是整数最小值，返回a除以b的结果
    public static int div(int a, int b) {
        // 负数转正数
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        // 符号一样返回正数 不一样返回负数
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }

    // 加法
    public static int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            // ans : a和b无进位相加的结果
            ans = a ^ b;
            // b : a和b相加时的进位信息
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    // 减法 add(a, add(~b, 1));
    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    // 相反数
    public static int neg(int n) {
        return add(~n, 1);
    }

    // 乘法
    public static int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                // 考察b当前最右的状态！
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;// 无符号右移
        }
        return ans;
    }

}
