package leetcode.everyday.June;

/**
 * @Author: zhqihang
 * @Date: 2024/06/07
 * @Project: coding
 * @Description: 相同分数的最大操作数目 1
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/
 */
public class Demo_0607 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        System.out.println(maxOperations(arr));
    }

    // 每次拿两个元素 求和 得到分数
    public static int maxOperations(int[] nums) {
        int score = nums[0] + nums[1];
        int ans = 1;
        for (int i = 0; i < nums.length && nums[i - 1] + nums[i] == score; i += 2) {
            ans++;
        }
        return ans;
    }
}
