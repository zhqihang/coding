package test;

/**
 * @Author: zhqihang
 * @Date: 2024/03/17
 * @Project: coding
 * @Description: ...
 */
public class Test02 {

    public static void main(String[] args) {
        String str = "words and 987";
        System.out.println("myAtoi(str) = " + myAtoi(str));
        System.out.println();
    }

    public static int myAtoi(String s) {
        int index = 0;
        int flag = 1;
        char[] chars = s.toCharArray();
        // 处理前导空格
        for (char c : chars) {
            if (c == ' ') {
                index++;
            } else {
                break;
            }
            // 此时index指向第一个非空格字符
        }
        // 判断符号
        if (chars[index] == '-') {
            flag = -flag;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        // 此时index指向第一个数字字符
        StringBuilder sb = new StringBuilder();
        for (; index < chars.length; index++) {
            if (chars[index] > 47 && chars[index] < 58)
                sb.append(chars[index]);
        }
        return flag * Integer.parseInt(sb.toString());
    }
}
