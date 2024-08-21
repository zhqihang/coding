package 左神算法.class30;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description: 找到缺失的数字
 * 测试链接 : https://leetcode.cn/problems/missing-number/
 */
public class Code03_MissingNumber {
    public int missingNumber(int[] nums) {
        int eorAll = 0, eorHas = 0;
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= i;
            eorHas ^= nums[i];
        }
        // 这一步不要忘记
        eorAll ^= nums.length;
        return eorAll ^ eorHas;
    }
}
