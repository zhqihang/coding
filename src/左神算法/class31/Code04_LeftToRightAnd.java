package 左神算法.class31;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description: 给你两个整数 left 和 right ，表示区间 [left, right]
 * 返回此区间内所有数字 & 的结果
 * 包含 left 、right 端点
 * 测试链接 : https://leetcode.cn/problems/bitwise-and-of-numbers-range/
 */
public class Code04_LeftToRightAnd {
    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            // 只要不相等 每次最右侧的 1 无意义（存在0 与之&） right - 最右侧的1 继续判断
            right -= right & -right;
        }
        return right;
    }
}
