package leetcode.everyday.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/28
 * @Project: coding
 * @Description: 寻找峰值
 * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
 * 以数组形式返回给定数组中 峰值 的下标，顺序不限 。
 * 注意：
 * - 峰值 是指一个严格大于其相邻元素的元素。
 * - 数组的第一个和最后一个元素 不 是峰值。
 * https://leetcode.cn/problems/find-the-peaks/
 * <p>
 * 和分发糖果一个思路
 */
public class Demo_0528 {

    // 遍历一遍 比较左右两个位置
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }

    // 峰值比两侧都大
    // 两次遍历 记录大于的下标 然后取交集
    public List<Integer> findPeaks1(int[] mountain) {
        int n = mountain.length;
        // 答案列表
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[n];
        Arrays.fill(arr, 0);
        // 左遍历
        for (int i = 1; i < n - 1; i++) {
            if (mountain[i] > mountain[i - 1]) {
                arr[i] = 1;
            }
        }
        // 右遍历
        for (int i = n - 2; i > 0; i--) {
            int a = 0;
            if (mountain[i] > mountain[i + 1]) {
                a = 1;
            }
            arr[i] &= a;
        }
        // 统计答案
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }
}
