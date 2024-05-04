package test;

/**
 * @Author: zhqihang
 * @Date: 2024/04/10
 * @Project: coding
 * @Description: ...
 */
public class Test1702 {

    public static void main(String[] args) {
        String binary = "000110";
        System.out.println("maximumBinaryString(binary) = " + maximumBinaryString(binary));
    }

    public static String maximumBinaryString(String binary) {
        int i = binary.indexOf('0');
        if (i < 0) return binary;
        char[] s = binary.toCharArray();
        int cnt1 = 0;
        for (i++; i < s.length; i++) {
            cnt1 += s[i] - '0';
        }
        //
        return "1".repeat(s.length - 1 - cnt1) + '0' + "1".repeat(cnt1);
    }
}
