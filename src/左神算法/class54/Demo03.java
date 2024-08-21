package 左神算法.class54;

import java.io.*;
import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 老板需要你帮忙浇花。给出 N 滴水的坐标，y表示水滴的高度，𝑥表示它下落到 x 轴的位置。
 * 每滴水以每秒 1 个单位长度的速度下落。
 * 你需要把花盆放在 x 轴上的某个位置，使得从被花盆接着的第 1 滴水开始，到被花盆接着的最后 1 滴水结束，之间的时间差至少为 D。
 * <p>
 * 我们认为，只要水滴落到 x 轴上，与花盆的边沿对齐，就认为被接住。给出N 滴水的坐标和D 的大小，请算出最小的花盆的宽度W。
 * <p>
 * 输入格式
 * 第一行2个整数 N 和 D。
 * 接下来 N 行每行 2 个整数，表示水滴的坐标 (x,y)。
 * 输出格式
 * 仅一行 1 个整数，表示最小的花盆的宽度。如果无法构造出足够宽的花盆，使得在 D 单位的时间接住满足要求的水滴，则输出 −1。
 * <p>
 * 输入示例:
 * 4 5
 * 6 3
 * 2 4
 * 4 10
 * 12 15
 * 输出:
 * 2
 * <p>
 * 解释: 有 4 滴水，(6,3) ，(2,4) ，(4,10) ，(12,15) 。水滴必须用至少 5 秒时间落入花盆。花盆的宽度为 2 是必须且足够的。
 * 把花盆放在 x=4…6 的位置，它可以接到 11 和 33 水滴, 之间的时间差为 10−3=7 满足条件。
 */
public class Demo03 {
    public static int MAXN = 100005;
    public static int[][] arr = new int[MAXN][2];

    public static int n, d;

    public static int[] maxDeque = new int[MAXN];
    public static int[] minDeque = new int[MAXN];

    public static int maxh, maxt, minh, mint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            d = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i][0] = (int) in.nval;
                in.nextToken();
                arr[i][1] = (int) in.nval;
            }
            int ans = compute();
            out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        out.flush();
        out.close();
        br.close();
    }

    private static int compute() {
        // 所有水滴排序 (指定在 x 轴上排序)
        Arrays.sort(arr, 0, n, (a, b) -> a[0] - b[0]);
        maxh = maxt = minh = mint = 0;
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; l < n; l++) {
            // [l, r)水滴的编号
            while (r < n && !ok()) {
                push(r++);
            }
            if (ok()) {
                ans = Math.min(ans, arr[r - 1][0] - arr[l][0]);
            }
            pop(l);
        }
        return ans;
    }

    private static void pop(int l) {
        if (maxh < maxt && maxDeque[maxh] == l) {
            maxh++;
        }
        if (minh < mint && minDeque[minh] == l) {
            minh++;
        }
    }

    private static void push(int r) {
        while (maxh < maxt && arr[maxDeque[maxt - 1]][1] <= arr[r][1]) {
            maxt--;
        }
        maxDeque[maxt++] = r;
        while (minh < mint && arr[minDeque[mint - 1]][1] >= arr[r][1]) {
            mint--;
        }
        minDeque[mint++] = r;
    }

    private static boolean ok() {
        int max = maxh < maxt ? arr[maxDeque[maxh]][1] : 0;
        int min = minh < mint ? arr[minDeque[minh]][1] : 0;
        return max - min >= d;
    }

}
