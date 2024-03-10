package lanqiao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author: qihang
 * @CreateDate: 2023/12/21/ 16:41
 * @Project: coding
 * @Description: 记一个日期为 yy 年 mm 月 dd 日，统计从 2000 年 1 月 1 日到 2000000 年 1 月 1 日
 * 有多少个日期满足年份 yy 是月份 mm 的倍数，同时也是 dd 的倍数
 */
public class Question_01 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.of(2000000, 1, 1);
        long count = 0;
        while (!startDate.equals(endDate)) {
            long year = startDate.getYear();
            int month = startDate.getMonthValue();
            int day = startDate.getDayOfMonth();
            if ((year % month == 0) && (year % day == 0)) {
                count++;
            }
            startDate = startDate.plusDays(1);
        }
        System.out.println(count);
    }
}
