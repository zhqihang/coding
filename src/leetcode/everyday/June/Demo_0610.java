package leetcode.everyday.June;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/06/10
 * @Project: coding
 * @Description: 求生艇
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回 承载所有人所需的最小船数 。
 * https://leetcode.cn/problems/boats-to-save-people/description/
 */
public class Demo_0610 {

    // 尽量每个船坐两个人
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0, l = 0, r = people.length - 1, sum = 0;
        while (l <= r) {
            // 判断是否是边界位置
            sum = l == r ? people[l] : people[l] + people[r];
            if (sum > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            ans++;
        }
        return ans;
    }
}
