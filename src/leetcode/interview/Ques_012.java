package leetcode.interview;

import java.util.Scanner;

/**
 * @Author: zhqihang
 * @Date: 2024/02/25
 * @Project: coding
 * @Description: 整数转罗马数字
 */
public class Ques_012 {

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intoRoman(int num) {
        StringBuffer roman = new StringBuffer(); // 线程安全 效率较低
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }


    public static void main(String[] args) {
        System.out.println("请输入数字，回车结束！");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int next = scanner.nextInt();
            if (next == -1) {
                System.exit(0);
            }
            System.out.println(intoRoman(next));
            System.out.println("继续或输入-1停止");
        }
        scanner.close();
    }
}
