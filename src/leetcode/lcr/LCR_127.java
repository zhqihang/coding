package leetcode.lcr;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class LCR_127 {
    public int trainWays(int num) {
        final int MOD = 1000000007;
        // 滚动数组实现
        int p = 0, q = 0, r = 1;
        for(int i = 1; i <= num; i++){
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
