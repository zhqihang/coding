package leetcode.hot100;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 最长连续子序列
 *
 */
public class Demo_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // 去重 并加入哈希表
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        // 遍历每个数x
        for (int num : set) {
            // 如果 x-1 存在则跳过该数字
            if (set.contains(num - 1)) continue;
            // 不存在开始遍历
            int curNum = num;
            int curLong = 1;
            // 遍历 x 之后的数字
            while (set.contains(curNum + 1)) {
                curLong++;
                curNum++;
            }
            longest = Math.max(curLong, longest);
        }
        return longest;
    }
}
