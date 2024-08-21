package 左神算法.class30;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description: 数组中有2种数出现了奇数次，其他的数都出现了偶数次
 * 返回这2种出现了奇数次的数
 * 测试链接 : https://leetcode.cn/problems/single-number-iii/
 */
public class Code05_DoubleNumber {
    public int[] singleNumber(int[] nums) {
        // eorAll = a ^ b
        // eorAll 中一定有一位是 1
        // a b划分为 这位是1 和不是1两个阵营
        int eor1 = 0;
        for (int num : nums) {
            eor1 ^= num;
        }

        // Brian Kernighan算法 取最右侧的1
        // n & (~n + 1) = 只保留最右侧1的二进制状态
        // 提取出二进制里最右侧的1
        // -eor1: 这是 eor1 的补码表示。补码是将原码取反然后加 1 得到的
        int rightOne = eor1 & (-eor1);
        int eor2 = 0;
        for (int num : nums) {
            // eor2只异或 与rightOne状态不相同的
            if ((num & rightOne) == 0) {
                eor2 ^= num;
            }
        }
        return new int[]{eor2, eor1 ^ eor2};
    }
}
