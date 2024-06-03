package leetcode.everyday.June;

/**
 * @Author: zhqihang
 * @Date: 2024/06/03
 * @Project: coding
 * @Description: 分糖果2
 * 排排坐，分糖果。
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
 * 注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * https://leetcode.cn/problems/distribute-candies-to-people/description/
 * <p>
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 */
public class Demo_0603 {
    // 糖果数 除以 人数的递增数列的和 商 和 余数
    public int[] distributeCandies(int candies, int num_people) {
        // m 次发糖分出了足够的糖果 则有 ((Math.sqrt(8.0 * candies + 1) - 1) / 2) 个糖果
        int m = (int) ((Math.sqrt(8.0 * candies + 1) - 1) / 2);
        // m 次发糖 是 k 次循环
        int k = m / num_people;
        // m + 1 次 剩余的糖果
        int extra = m % num_people;
        // 答案数组
        int[] ans = new int[num_people];
        // 循环发糖
        for (int i = 0; i < num_people; i++) {
            ans[i] = k * (k - 1) / 2 * num_people + k * (i + 1) +
                    (i < extra ? k * num_people + i + 1 : 0); // 最后一轮 不构成循环的糖果
        }
        ans[extra] += candies - m * (m + 1) / 2;
        return ans;
    }
}
