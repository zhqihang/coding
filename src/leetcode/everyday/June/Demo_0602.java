package leetcode.everyday.June;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/06/02
 * @Project: coding
 * @Description: 分糖果
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。
 * Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。
 * Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * 给你一个长度为 n 的整数数组 candyType ，
 * 返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。
 * https://leetcode.cn/problems/distribute-candies/description
 * <p>
 * 输入：candyType = [1,1,2,2,3,3]
 * 输出：3
 * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
 */
public class Demo_0602 {

    public int distributeCandies(int[] candyType) {
        // 得到 糖果类型数
        Set<Integer> set = new HashSet<>();
        for (int t : candyType) {
            set.add(t);
        }
        // 返回类型数 和 医生要求的最小值 就是最多的种类数
        return Math.min(set.size(), candyType.length / 2);
    }
}
