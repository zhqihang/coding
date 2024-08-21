package 左神算法.class31;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description: 判断一个数是不是3的幂
 * https://leetcode.cn/problems/power-of-three
 */

public class Code02_PowerOfThere {
    public boolean isPowerOfThree(int n) {
        // 3的19次方
        return n > 0 && 1162261467 % n == 0;
    }
}
