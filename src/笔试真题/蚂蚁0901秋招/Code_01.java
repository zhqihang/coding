package 笔试真题.蚂蚁0901秋招;

import java.util.Scanner;

/**
 * @description: 三字母辩论会
 * @author: zhqihang
 * @date: 2024/09/01
 * 三个人面对面坐着交谈，每一个单位时间他们都会说出一个字母，当有任何两个人的字母相同时，他们两个都会觉得聊的很投机。
 * 机器人已经记录下了每个人在整个交谈期间说过的所有话，你需要统计他们每个人在交谈过程中会有多少个单位时间是觉得自己聊的很投机的。
 * 输入描述
 * 第一行输入一个整数 n（1<=n<=10^6） 代表交谈时长。
 * 第二行输入一个长度为 n ，且只由小写字母构成的字符串 s 。
 * 第三行输入一个长度为 n，且只由小写字母构成的字符串 t 。
 * 第四行输入一个长度为 n ，且只由小写字母构成的字符串 u 。
 * 输出描述
 * 在一行上输出三个整数，代表第一个人、第二个人和第三个人觉得自己聊得很投机的次数。
 * 示例 1
 * 输入
 * 3
 * abc
 * abd
 * bbe
 * 输出
 * 2 2 1
 * 说明
 * 在第一个时刻，第一个人和第二个人都说了字母 a，他们会觉得聊得很投机，答案为 1,1,0 ；
 * 在第二个时刻，三个人同时说了同一个字母 b ，他们都会觉得聊得很投机，答案为 2,2,1 ；
 * 在第三个时刻，三个人说的字母不一样，没人会觉得聊的很投机。
 */
public class Code_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 交谈时长
        scanner.nextLine(); // 消除换行符
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        String u = scanner.nextLine();

        int r1 = 0, r2 = 0, r3 = 0;
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i), b = t.charAt(i), c = u.charAt(i);
            // 只需要分别判断 当前位置 是否需要加分即可
            if (a == b || a == c) r1++;
            if (b == a || b == c) r2++;
            if (c == a || c == b) r3++;
        }
        System.out.println(r1 + " " + r2 + " " + r3);
        scanner.close();
    }
}
