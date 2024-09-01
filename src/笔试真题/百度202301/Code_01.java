package 笔试真题.百度202301;

import java.io.*;
import java.util.Scanner;

/**
 * @description: 讨厌鬼的组合帖子
 * @author: zhqihang
 * @date: 2024/08/22
 * 题目描述
 * 讨厌鬼有 n 个帖子。第 i 个帖子的点赞数为 a[i] 点踩数为 b[i]。你可以选择任意个帖子组合起来。
 * 组合帖子的点赞数和点踩数为所有被组合帖子点赞数和点踩数之和。
 * 已知一个帖子的点赞数为 x，点踩数为 y，则该帖子的吸引度为 |x - y|。
 * 讨厌鬼需要选择若干个帖子组合起来，使得这个组合帖子的吸引度尽可能大。请你告诉他这个吸引度最大是多少？
 * 输入描述
 * 第一行输入一个整数 n(1 <= n <= 10^5)。
 * 第二行输入 n 个整数 a[i](1 <= a[i] <= 10^9)
 * 第三行输入 n 个整数 b[i](1 <= b[i] <= 10^9)。
 * 输出描述
 * 一行一个整数，表示最大吸引度。
 * 输入示例
 * 4
 * 4 2 1 1
 * 2 1 4 4
 * 输出示例
 * 6
 * 提示信息
 * 选择第 3 个和第 4 个帖子组合后，点赞数为 2，点踩数为 8，吸引度为|2 - 8| = 6。
 */
public class Code_01 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); // 读取 n 之前的分隔符
        n = (int) in.nval; // 读取 n
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken(); // 读取 a[i] 之前的分隔符
            a[i] = (int) in.nval; // 读取 a[i]
        }
        for (int i = 0; i < n; i++) {
            in.nextToken(); // 读取 b[i] 之前的分隔符
            b[i] = (int) in.nval; // 读取 b[i]
        }
        out.print(f(n, a, b));
        out.flush();
        out.close();
    }

    // n个帖子数组a为点赞数 数组 b 为点踩数
    private static long f(int n, int[] a, int[] b) {
        // 计算所有帖子的吸引度
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            int num = a[i] - b[i]; // 包含正数和负数
            if (num >= 0) {
                sum1 += num;
            } else {
                sum2 += num;
            }
        }
        return Math.max(sum1, -sum2);
    }
}