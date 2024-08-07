package leetcode.everyday.May;

/**
 * @Author: zhqihang
 * @Date: 2024/05/27
 * @Project: coding
 * @Description: 找出缺失的观测数据
 * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。
 * 观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
 * 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
 * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。
 * 如果存在多组符合要求的答案，只需要返回其中任意一组即可。
 * 如果不存在答案，返回一个空数组。
 * k 个数字的 平均值 为这些数字求和后再除以 k 。
 * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
 * 输入：rolls = [3,2,4,3], mean = 4, n = 2
 * 输出：[6,6]
 * <p>
 * https://leetcode.cn/problems/find-missing-observations/description
 */
public class Demo_0527 {
    //
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        for (int roll : rolls) {
            sum -= roll;
        } // 此时 sum 为 n 数组的和
        if (sum < n || sum > 6 * n) {
            // 不满足 答案不存在
            return new int[]{};
        }
        int avg = sum / n;
        int extra = sum % n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // 全部设置为 avg 剩余的余数分摊给前面几位
            ans[i] = avg + (i < extra ? 1 : 0); // 优雅
        }
        return ans;
    }
}
