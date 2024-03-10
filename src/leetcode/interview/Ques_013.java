package leetcode.interview;

import java.util.Scanner;

/**
 * @author: qihang
 * @CreateDate: 2023/12/22/ 15:37
 * @Project: coding
 * @Description: ......
 */
public class Ques_013 {

    public static void main(String[] args) {
        System.out.println("请输入罗马数字，回车结束！");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            if ("1".equals(next)){
                System.exit(0);
            }
            System.out.println(romanToInt(next));
            System.out.println("继续或输入1停止");
        }
        scanner.close();
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValues(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValues(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum; // 最后一位直接加
        return sum;
    }

    public static int getValues(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
