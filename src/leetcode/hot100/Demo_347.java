package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description: 前K个高频元素
 * @author: zhqihang
 * @date: 2024/08/24
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Demo_347 {
    /*
    哈希表记录每个数字出现的次数 出现次数数组
    问题转化为：找出哈希表中 前 k 大的值
    建立小根堆，遍历哈希表
        - 如果堆的元素个数小于 k, 直接入堆
        - 如果堆的元素个数等于 k, 则检查堆顶元素出现次数与当前出现次数的大小
            - 如果堆顶更大，说明至少有k个数字的出现次数比当前值大 舍弃当前值
            - 如果元素更大，弹出堆顶，当前值插入堆中

     遍历完成后 堆中元素就是答案
     */

    public static void main(String[] args) {
        int[] ints = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(topKFrequent(ints, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 数字：出现次数
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小根堆（根据元素对应的次数进行排序）
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[1] - b[1])); // 比较器写法
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }
            if (heap.size() == k && entry.getValue() > heap.peek()[1]) {
                heap.poll();
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int size = heap.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = heap.poll()[0];
        }
        return ans;
    }

}
