package learn.class30;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description:
 *
 * 数组中1种数出现了奇数次，其他的数都出现了偶数次
 * 返回出现了奇数次的数
 * 测试链接 : https://leetcode.cn/problems/single-number/
 */
public class Code04_SingleNumber {

    // 异或的结果和数字的关系没有关系 满足交换律
    public int singleNumber(int[] nums) {
        int eorAll = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     eorAll ^= nums[i];
        // }
        for (int num : nums) {
            eorAll ^= num;
        }
        return eorAll;
    }
}
