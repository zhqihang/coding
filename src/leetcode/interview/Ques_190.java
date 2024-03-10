package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/20
 * @Project: coding
 * @Description: 颠倒二进制位
 * <p>
 * 颠倒给定的32位无符号整数的二进制位
 */
public class Ques_190 {

    // you need treat n as an unsigned value

    // 按位翻转
    public int reverseBits(int n) {
        int rev = 0;

        // 循环32次或者n为0时，提前退出循环
        for (int i = 0; i < 32 && n != 0; i++) {
            // 将n的最低位加入rev
            rev |= (n & 1) << (31 - i); // 按位或运算
            // 无符号右移一位
            n >>>= 1;
        }
        return rev;
    }

}
