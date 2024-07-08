package learn.class00;

import java.io.*;

/**
 * @author: qihang
 * @CreateDate: 2023/12/18/ 15:49
 * @Project: coding
 * @Description: 归并排序
 * 1）左部分排好序、右部分排好序、利用merge过程让左右整体有序
 * 2）merge过程：谁小拷贝谁，直到左右两部分所有的数字耗尽，拷贝回原数组
 * 3）递归实现和非递归实现
 * 4）时间复杂度O(n * log n)
 * 5）需要辅助数组，所以额外空间复杂度O(n)
 * 6）归并排序为什么比O(n^2)的排序快？因为比较行为没有浪费！
 * 7）利用归并排序的便利性可以解决很多问题 - 归并分治 - 下节课
 */
public class Video_021 {

    public static int MAX_N = 501;
    public static int[] arr = new int[MAX_N];
    public static int[] help = new int[MAX_N];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            // 归并排序算法
            mergeSort(0, n - 1);
            mergeSort1();
            out.print(arr[0]);
            for (int i = 0; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    // 递归版 归并排序
    private static void mergeSort(int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    // 非递归版 使用步长进行控制
    private static void mergeSort1() {
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }

    // 合并函数
    private static void merge(int l, int m, int r) {
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++]; // a++满足终止条件 a <= m
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i < r; i++) {
            arr[i] = help[i];
        }
    }
}
