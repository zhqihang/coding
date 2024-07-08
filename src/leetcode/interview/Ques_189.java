package leetcode.interview;


/**
 * @Author: zhqihang
 * @Date: 2023/12/28
 * @Project: coding
 * @Description: 轮转数组
 */
public class Ques_189 {

    // 环状替换
    public void rotate1(int[] nums, int k) {
        int n = nums.length;

        k = k % n;
        int count = gcd(k, n);// 移动总次数
        // n为偶数时, 会形成多个换环
        for (int start = 0; count < n; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = next;
                current = next;
            } while (start != current);
        }
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    // 辅助数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] help = new int[n];
        for (int i = 0; i < n; ++i) {
            help[(i + k) % n] = nums[i];
        }
        // 原数组 原数组起始索引 目标数组 目标数组起始索引 要复制数组长度
        System.arraycopy(help, 0, nums, 0, n);
    }
}
