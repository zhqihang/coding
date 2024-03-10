package lanqiao;

import java.time.LocalDate;

/**
 * @author: qihang
 * @CreateDate: 2023/12/21/ 17:14
 * @Project: coding
 * @Description: 对于一个日期，我们可以计算出年份的各个数位上的数字之和，也可以分别计算月和日的各位数字之和。
 * 请问从1900年1月1日至9999年12月31日，总共有多少天，年份的数位数字之和等于月的数位数字之和加日的数位数字之和。
 */
public class Question_01_1 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(1900, 1, 1);
        LocalDate endDate = LocalDate.of(9999, 12, 31);
        long count = 0;
        while (!startDate.equals(endDate)) {
            long year = startDate.getYear();
            int month = startDate.getMonthValue();
            int day = startDate.getDayOfMonth();
            int y1 = (int) (year / 1000);
            int y2 = (int) (year / 100 % 10);
            int y3 = (int) (year / 10 % 10);
            int y4 = (int) (year % 10);
            int m1 = month / 10;
            int m2 = month % 10;
            int d1 = day / 10;
            int d2 = day % 10;
            if ((y1 + y2 + y3 + y4) == (m1 + m2 + d1 + d2)) {
                count++;
            }
            startDate = startDate.plusDays(1);
        }
        System.out.println(count);
    }
}
