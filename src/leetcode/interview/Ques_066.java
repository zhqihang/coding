package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/23
 * @Project: coding
 * @Description: 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Ques_066 {
    // 要考虑进位的问题
    // 最长的后缀9
    // 从后往前找到第一个不为9的元素，加1，后面全部置零
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < len; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        // 不进if  9999
        int[] ans = new int[len + 1];
        ans[0] = 1;
        return ans;
    }
}
