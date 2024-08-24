package 笔试真题.美团0810秋招;

import java.io.*;
import java.util.*;

/**
 * @description: 小美的密码
 * @author: zhqihang
 * @date: 2024/08/18
 * 小美准备登录美团，需要输入密码，小美忘记了密码，只记得密码可能是 n个字符串中的一个。
 * 小美会按照密码的长度从小到大依次尝试每个字符串，对于相同长度的字符串，小美随机尝试，并且相同的密码只会尝试一次。
 * 小美想知道，她最少需要尝试多少次才能登录成功，最多需要尝试多少次才能登录成功。
 * 小美不会重新尝试已经尝试过的字符串。成功登录后会立即停止尝试。
 * 输入描述
 * 第一行输入一个整数 n(1 <= n <= 1000)代表密码字符串的个数。
 * 第二行输入一个只由小写字母组成的字符串 s(1<=|s|<=1000)代表正确的密码。
 * 接下来 n 行，每行输入一个长度不超过 1000的字符串，代表小美记得的密码。
 * 输出描述
 * 在一行上输出两个整数，表示最少和最多尝试次数。
 * 输入
 * 4
 * ab
 * abc
 * ab
 * ac
 * ac
 * 输出
 * 1 2
 * https://mp.weixin.qq.com/s/5BaXwpLG9d--Qoto9YZybA
 */
public class Code_01 {
    public static void main(String[] args) throws IOException {
        // Scanner scan = new Scanner(System.in);
        // int nums = scan.nextInt(); // 字符串个数
        // scan.nextLine(); // 消耗掉nextInt留下来的换行符
        // String ans = scan.nextLine(); // 正确答案

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // 相同的密码只会尝试一次 所以使用 集合 接收字符串
        // 每种长度字符对应的哈希表：(字符长度 ：字符集合)
        Map<Integer, Set<String>> pos = new HashMap<>();
        String ans = null;
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            ans = in.sval; // 正确答案序列
            // 循环读取
            for (int i = 0; i < n; i++) {
                in.nextToken();
                String str = in.sval;
                // computeIfAbsent方法：如果指定的键不存在 则使用提供的映射函数新增，如果键存在，则什么都不做
                pos.computeIfAbsent(str.length(), k -> new HashSet<>()).add(str);
            }
        }
        // 算法
        int[] extracted = extracted(pos, ans);
        out.print(extracted[0] + " " +extracted[1]);
        out.flush();
        out.close();
    }

    private static int[] extracted(Map<Integer, Set<String>> pos, String ans) {
        // map 放入列表中
        // pos.entrySet() 返回 一个 Set集合
        List<Map.Entry<Integer, Set<String>>> sortedPos = new ArrayList<>(pos.entrySet());
        // 按照字符长度进行列表排序
        sortedPos.sort(Map.Entry.comparingByKey());
        // 遍历尝试 更新最小最大尝试次数
        int step = 0;
        int MIN = -1, MAX = -1;
        for (Map.Entry<Integer, Set<String>> entry : sortedPos) {
            Set<String> v = entry.getValue();
            if (v.contains(ans)) {
                // 这个长度下包含正确答案
                MIN = step + 1; // 第一次就试到了正确答案
                MAX = step + v.size(); // 所有字符都尝试一遍
            } else {
                // 这个长度下没有正确答案
                step += v.size(); // 需要从短的开始 所以全部都要尝试一遍
            }
        }
        return new int[]{MIN, MAX};
    }
}
