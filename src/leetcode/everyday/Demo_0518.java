package leetcode.everyday;

/**
 * @Author: zhqihang
 * @Date: 2024/05/18
 * @Project: coding
 * @Description:
 * https://leetcode.cn/problems/find-the-maximum-divisibility-score
 */
public class Demo_0518 {

    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = 0;
        int maxCnt = -1;
        for (int d : divisors) {
            int cnt = 0;
            for (int x : nums) {
                if (x % d == 0) {
                    cnt++;
                }
            }
            if (cnt > maxCnt || cnt == maxCnt && d < ans) {
                maxCnt = cnt;
                ans = d;
            }
        }
        return ans;
    }
}
