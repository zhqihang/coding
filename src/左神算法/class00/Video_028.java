package 左神算法.class00;

import java.io.*;
import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2023/12/28
 * @Project: coding
 * @Description: 基数排序
 */
public class Video_028 {

    // 进制数 用于取每位的数
    public static int BASE = 10;

    public static int MAX_N = 501;

    // 原数组
    public static int[] arr = new int[MAX_N];
    // 辅助数组
    public static int[] help = new int[MAX_N];
    // 统计数组
    public static int[] cnts = new int[BASE];
    // 数组长度
    public static int n;

    public static void main(String[] args) throws IOException {
        // 从标准输入读取字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 将输入流分词成标记
        StreamTokenizer in = new StreamTokenizer(br);
        // 用于向标准流写入字符流
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // 循环读入 并进行相应操作
        while (in.nextToken() != StreamTokenizer.TT_EOF) { // 控制台 ctrl + D
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            // 排序算法
            sort();
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static void sort() {
        // 找到数组中的最小值
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            // 数组中的每个数字减去数组中的最小值 arr就变为非负数组
            arr[i] -= min;
            // 记录数组中的最大值
            max = Math.max(arr[i], max);
        }
        // 根据最大值在BASE进制下的位数, 决定基数排序要做多少轮
        radixSort(bits(max));
        // 数组中的数 加上最小值 进行还原
        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }
    }

    // 获取一个数字在BASE进制下的的位数
    public static int bits(int number) {
        int ans = 0;
        while (number > 0) {
            ans++;
            number /= BASE;
        }
        return ans;
    }

    // 基数排序核心代码
    // arr中保证没有负数
    // n是arr的长度
    // bits是arr中最大值在BASE进制下有几位
    public static void radixSort(int bits) {
        // 基数排序需要过 bits 轮
        // offset是取位时的除数
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0); // 数组初始化 全置0
            // cnts记录每个数字出现的频率
            for (int i = 0; i < n; i++) {
                // 数字提取某一位
                cnts[(arr[i] / offset) % BASE]++; // 取数 所在词频 +1
            }
            // 处理成前缀次数累加的形式
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i] + cnts[i - 1]; // < 3 的包含 < 2 的
            }
            // 从右往左遍历
            for (int i = n - 1; i >= 0; i--) {
                // arr中的 i 去到 help 中当前数字--的位置
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = help[i]; // help刷回arr
            }
        }
    }
}
