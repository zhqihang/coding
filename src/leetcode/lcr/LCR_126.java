package leetcode.lcr;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/description/
 */
public class LCR_126 {
    // 动态规划 滚动数组实现
    public int fib(int n) {
        final int MOD = 1000000007;
        if(n < 2){
            return n;
        }
        // 初始状态
        int p = 0, q = 0, r = 1;
        // 滚动求值
        for(int i = 2; i <= n; i++){
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
