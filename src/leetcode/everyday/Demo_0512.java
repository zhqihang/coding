package leetcode.everyday;

import test.IntegerTest;

import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhqihang
 * @Date: 2024/05/12
 * @Project: coding
 * @Description: 吃掉橘子的最少天数
 * 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
 * 1. 吃掉一个橘子。
 * 2. 如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子, 剩余 n/2 个橘子。
 * 3. 如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子, 剩余 n/3 个橘子。
 * 每天你只能从以上 3 种方案中选择一种方案。
 * 请你返回吃掉所有 n 个橘子的最少天数。
 * https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges/description/
 * <p>
 * 解题思路:
 * 深度优先 记忆化搜索 递归
 * 先执行 i%2 次减一操作 把i变为2的倍数 再执行除以2
 * 先执行 i%3 次减一操作 把i变为3的倍数 再执行除以3
 * 两者取最小值
 */
public class Demo_0512 {
    // 记忆集合
    public static Map<Integer, Integer> memo = new HashMap<>();
    // 深度优先搜索
    public int minDays(int n) {
        // 递归出口
        if (n <= 1) {
            return n;
        }
        Integer res = memo.get(n);
        if (res != null) {
            return res;
        }
        // 先执行 i%2 次减一操作 把i变为2的倍数 再执行除以2
        // 先执行 i%3 次减一操作 把i变为3的倍数 再执行除以3
        // 两者取最小值
        res = Math.min(minDays(n / 2) + n % 2, minDays(n / 3) + n % 3) + 1;
        memo.put(n, res);
        return res;
    }
}
