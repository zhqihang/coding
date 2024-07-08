package test.yunzhi;

import java.util.Scanner;

/**
 * @Author: zhqihang
 * @Date: 2024/04/18
 * @Project: coding
 * @Description: ...
 */
public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int last = -1;
        long ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == 'd') {
                i++;
                continue;
            }
            int j = i;
            while (j < s.length() && s.charAt(j) != 'd') j++;
            int lastx = -1;
            int lasty = -1;
            for (int k = i; k < j; k++) {
                if (s.charAt(k) == 'r') {
                    if (lasty != -1) {
                        ans += lasty - i + 1;
                    }
                    lastx = k;
                } else if (s.charAt(k) == 'e') {
                    if (lastx != -1) {
                        ans += lastx - i + 1;
                    }
                    lasty = k;
                } else {
                    int z = Math.min(lastx, lasty);
                    if (z != -1) {
                        ans += z - i + 1;
                    }
                }
            }

            i = j;
        }
        System.out.println(ans);
    }
}
