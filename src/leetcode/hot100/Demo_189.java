package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/08
 * @Project: coding
 * @Description: 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 思路:
 *
 */
public class Demo_189 {

    // 环状替换
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n); // 循环轮数

        for (int start = 0; start < count; start++) {
            int cur = start;
            int pre = nums[start];
            do {
                int next = (cur + k) % n;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
            }while (start != cur);
        }
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
