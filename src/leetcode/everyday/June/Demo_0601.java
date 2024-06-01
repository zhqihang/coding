package leetcode.everyday.June;

/**
 * @Author: zhqihang
 * @Date: 2024/06/01
 * @Project: coding
 * @Description: 给小朋友分发糖果 1
 * 给你两个正整数 n 和 limit 。
 * 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
 * 输入：n = 5, limit = 2
 * 输出：3
 *
 * https://leetcode.cn/problems/distribute-candies-among-children-i/description/
 *
 * 先计算不受限制的所有方案数 再减去不满足 limit 的方案数
 */
public class Demo_0601 {
    // 糖果必须分完 而且不能超过 limit
    public int distributeCandies(int n, int limit) {
        return c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit - 1);
    }

    private int c2(int n) {
        return n > 1 ? n * (n - 1) / 2 : 0;
    }
}
