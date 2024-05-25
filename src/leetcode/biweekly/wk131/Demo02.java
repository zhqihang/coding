package leetcode.biweekly.wk131;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhqihang
 * @Date: 2024/05/25
 * @Project: coding
 * @Description: 查询数组中元素的出现位置
 * 给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。
 * 对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，并返回它的下标。
 * 如果数组中 x 的出现次数少于 queries[i] ，该查询的答案为 -1 。
 * 请你返回一个整数数组 answer ，包含所有查询的答案。
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] queries = {10};
        int x = 5;
        for (int i : occurrencesOfElement(nums, queries, x)) {
            System.out.print(i + " ");
        }
    }


    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        // 创建一个哈希表来存储元素 x 的所有出现位置
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 遍历 nums 数组并记录每个元素的出现位置
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        // 创建结果数组
        int[] ans = new int[queries.length];

        // 遍历 queries 数组并找到每个查询的答案
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            if (map.containsKey(x) && map.get(x).size() >= query) {
                ans[i] = map.get(x).get(query - 1);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}
