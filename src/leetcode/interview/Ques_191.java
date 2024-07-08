package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/21
 * @Project: coding
 * @Description: 位1的个数
 * <p>
 * 编写一个函数，输入是一个无符号整数（二进制串的形式），返回其二进制表达式中数字位数位1的个数
 */
public class Ques_191 {

    // 汉明重量
    public int hammingWeight(int n) {
        // 取每一位

        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
