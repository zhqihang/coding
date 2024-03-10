package lanqiao;

import java.time.LocalDate;

/**
 * @author: qihang
 * @CreateDate: 2023/12/21/ 17:11
 * @Project: coding
 * @Description:
 *
 *  与或异或
 */
public class Question_02 {
    static int ans = 0;
    public static void main(String[] args) {
        // 初始化数组
        int[][] a = new int[5][5];
        a[0][0] = 1;
        a[0][1] = 0;
        a[0][2] = 1;
        a[0][3] = 0;
        a[0][4] = 1;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                a[i][j] = 0;
            }
        }

        f(1, 0, 0, a);
        f(1, 0, 1, a);
        f(1, 0, 2, a);
        System.out.println(ans);
    }

    /*
    i 表示当前行数。
    j 表示当前行中的列数。
    s 表示使用的门电路类型（0表示与门，1表示或门，2表示异或门）。
    a 是电路的状态数组。
     */
    static void f(int i, int j, int s, int[][] a) {
        // base case
        if (i >= 5 || j >= 5 - i) {
            return;
        }

        if (s == 0)
            a[i][j] = a[i - 1][j] & a[i - 1][j + 1];
        else if (s == 1)
            a[i][j] = a[i - 1][j] | a[i - 1][j + 1];
        else
            a[i][j] = a[i - 1][j] ^ a[i - 1][j + 1];

        if (i == 4 && j == 0 && a[i][j] == 1) {
            ans++;
            return;
        }

        if (j < 5 - i - 1) {
            j++;
        } else {
            i++;
            j = 0;
        }
        f(i, j, 0, a);
        f(i, j, 1, a);
        f(i, j, 2, a);
    }
}
