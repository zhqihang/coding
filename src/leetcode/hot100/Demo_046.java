package leetcode.hot100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/06/17
 * @Project: coding
 * @Description: 全排列
 * https://leetcode.cn/problems/permutations/?envType=study-plan-v2&envId=top-100-liked
 */
public class Demo_046 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    private void f(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            ans.add(cur);
        } else {
            // j 是要交换到 i 位置的数字
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                f(nums, i + 1, ans);
                swap(nums, i, j); // 恢复现场
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
