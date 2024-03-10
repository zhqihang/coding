package learn.class31;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description: 逆序二进制的状态
 * 测试链接 : https://leetcode.cn/problems/reverse-bits/
 */
public class Code05_ReverseBits {
    // 逆序二进制的状态
    public static int reverseBits(int n) {
        // 1 V 1 交换  保留-->刷0-->移位-->或
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        // 2 V 2 交换
        n = ((n & 0xcccccccc) >>> 1) | ((n & 0x33333333) << 1);
        // 4 V 4 交换
        n = ((n & 0xf0f0f0f0) >>> 1) | ((n & 0x0f0f0f0f) << 1);
        // 8 V 8 交换
        n = ((n & 0xff00ff00) >>> 1) | ((n & 0x00ff00ff) << 1);
        // 16 V 16  低16位 高16位 或
        n = (n >>> 16) | (n << 16);
        return n;
    }
}
