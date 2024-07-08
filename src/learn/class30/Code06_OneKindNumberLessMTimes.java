package learn.class30;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description: 测试链接 : https://leetcode.cn/problems/single-number-ii/
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * <p>
 * 请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 */
public class Code06_OneKindNumberLessMTimes {

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        int m = 3;
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (counts[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
