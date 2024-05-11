package test;

/**
 * @Author: zhqihang
 * @Date: 2024/05/10
 * @Project: coding
 * @Description: ...
 */
public class Test_135 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        // 从前往后发糖果数组
        int[] candya = new int[len];
        // 从后往前发糖果数组
        int[] candyb = new int[len];
        // 总的糖果数
        int nums = 0;

        candya[0] = 1; // 第一个同学直接发一个糖果
        // 第一次从左往右遍历
        for (int i = 1; i < len; i++) {
            candya[i] = 1; // 每个人至少有一个 所以先发一个
            // 如果当前比左边分数高 当前比左边多发一个
            if (ratings[i] > ratings[i - 1]) {
                candya[i] = candya[i - 1] + 1;
            }
        }

        candyb[len - 1] = 1; // 最后一个同学直接发一个糖果
        // 第二次从右往左遍历
        for (int j = len - 2; j >= 0; j--) {
            candyb[j] = 1; // 每个人至少有一个 所以先发一个
            // 如果当前比右边分数高 当前比右边多发一个
            if (ratings[j] > ratings[j + 1]) {
                candyb[j] = candyb[j + 1] + 1;
            }
        }
        // 计算
        for (int i = 0; i < candya.length; i++) {
            nums += Math.max(candya[i], candyb[i]);
        }
        return nums;
    }
}
