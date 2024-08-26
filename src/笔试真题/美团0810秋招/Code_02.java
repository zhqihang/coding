package 笔试真题.美团0810秋招;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description: 小美的数组删除
 * @author: zhqihang
 * @date: 2024/08/18
 * 小美有一个长度为 n 的数组 a1,a2,....,an ，他可以对数组进行如下操作：
 * ● 删除第一个元素 a1，同时数组的长度减一，花费为 x。
 * ● 删除整个数组，花费为 k*MEX(a) （其中 MEX(a) 表示 a 中未出现过的最小非负整数。
 * 例如 [0,1,2,4] 的 MEX 为 3 ）。
 * 小美想知道将 a 数组全部清空的最小代价是多少，请你帮帮他吧。
 * 输入描述
 * 每个测试文件均包含多组测试数据。
 * 第一行输入一个整数 T(1<=T<=1000) 代表数据组数，每组测试数据描述如下：
 * 第一行输入三个正整数 n,k,x(1<=n<=2*10^5, 1<=k,x<=10^9) 代表数组中的元素数量、删除整个数组的花费系数、删除单个元素的花费。
 * 第二行输入 n 个整数 a1,a2,....,an(0<=ai<=n)，表示数组元素。
 * 除此之外，保证所有的 n 之和不超过 2*10^5。
 * 输出描述
 * 对于每一组测试数据，在一行上输出一个整数表示将数组中所有元素全部删除的最小花费。
 * 输入
 * 1
 * 6 3 3
 * 4 5 2 3 1 0
 * 输出
 * 15
 * https://mp.weixin.qq.com/s/5BaXwpLG9d--Qoto9YZybA
 */
public class Code_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 数据组数

        // 循环获取每一组数据
        while (T-- > 0) {
            long n = scanner.nextLong(); // 元素数量
            long k = scanner.nextLong(); // 删除整个数组的花费系数
            long x = scanner.nextLong(); // 删除单个元素的花费
            // 数组 A
            long[] A = new long[(int) n];
            for (int i = 0; i < n; ++i) {
                A[i] = scanner.nextLong();
            }

            // 将 A 数组全部清空的最小代价是多少？
            // dp数组：dp[i] 表示从数组的第 i 个元素开始，删除剩余所有元素的最小花费
            long[] dp = new long[(int) (n + 1)];
            Arrays.fill(dp, Long.MAX_VALUE);

            // 从后往前递推 边界条件就是 dp[n] 此时为 0
            dp[(int) n] = 0; // 初始化

            Set<Long> vst = new HashSet<>();
            long suffix_MEX = 0; // 未出现的最小非负整数

            // 遍历
            for (int i = (int) (n - 1); i >= 0; --i) {
                // 获取 MEX
                vst.add(A[i]);
                while (vst.contains(suffix_MEX)) {
                    suffix_MEX++;
                }
                // 递推公式：
                //  1. 删除当前元素：下一步考虑删除从 i+1 开始的元素 所以花费为 x + dp[i+1]
                //  2. 删除所有元素：k * MEX
                dp[i] = Math.min(dp[i + 1] + x, k * suffix_MEX);
            }
            // 打印答案
            System.out.println(dp[0]);
        }
        scanner.close();
    }

}
