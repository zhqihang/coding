package yunzhi;

import java.util.Scanner;

/**
 * @Author: zhqihang
 * @Date: 2024/04/18
 * @Project: coding
 * @Description: 给定两个正整数a和b，请你找到一个非负整数x满定0 < x<= b，
 * 使得x与a的异或值最大,异或指的是位运算中的异或，
 * 对两个二进制数字的每一位进行运算，若两位相同，则异或后的值为 0，否则为 1。
 * 例如(1010)2 ^ (0011)2 =(1001)，其中^为异或运算。
 *
 * 输入一行包含两个正整数 a,b(1 <= a,b<=1e9)
 *
 * 输出一行一个正整数表示异或的最大值。
 *
 * 输入
 * 3 6
 *
 * 输出
 * 7
 *
 * 说明
 * 从0~ 6中选择一个数字4,4和3异或得到7，这是最大的异或结果。
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 小孩数量
        int m = scanner.nextInt(); // 苹果数量
        int k = scanner.nextInt(); // 小明的编号

        // 可以发现规律：相邻编号的小孩分到的苹果数目差距不能大于1，所以每个小孩分到的苹果数应该是一个递增或递减的序列
        // 我们可以假设每个小孩分到的苹果数是一个等差数列，小明所在的位置为等差数列的中间位置

        // 等差数列的长度为 n 时，首项为 1，末项为 m，求和公式为：(首项 + 末项) * 项数 / 2 = m
        // 根据题意，小明所在的位置是 k，所以小明左边有 k - 1 个小孩，右边有 n - k 个小孩

        // 将苹果数 m 减去小明所在位置左边小孩分到的苹果数之和，即可得到小明分到的苹果数

        // 小明左边小孩分到的苹果数之和为 (1 + (k - 1)) * (k - 1) / 2
        int leftSum = (1 + (k - 1)) * (k - 1) / 2;

        // 小明右边小孩分到的苹果数之和为 (1 + (n - k)) * (n - k) / 2
        int rightSum = (1 + (n - k)) * (n - k) / 2;

        // 计算小明分到的苹果数
        int mingApples = m - leftSum - rightSum;

        System.out.println(mingApples);
    }
}
