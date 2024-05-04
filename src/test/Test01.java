package test;

import java.util.ArrayList;

/**
 * @author: qihang
 * @CreateDate: 2023/12/21/ 14:03
 * @Project: coding
 * @Description: ......
 */
import java.util.Scanner;
import java.util.HashMap;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test01 {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int n, aim;

    // key : 某个前缀和
    // value : 这个前缀和最早出现的位置
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            aim = in.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
        }
        System.out.println(compute());
    }


    public static int compute() {
        map.clear();
        // 重要 : 0这个前缀和，一个数字也没有的时候，就存在了
        map.put(0, -1);
        int ans = 0;
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)) {
                ans = Math.max(ans, i - map.get(sum - aim));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
