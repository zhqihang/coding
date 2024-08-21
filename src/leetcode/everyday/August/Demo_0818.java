package leetcode.everyday.August;

/**
 * @description: 学生出勤记录
 * @author: zhqihang
 * @date: 2024/08/18
 * https://leetcode.cn/problems/student-attendance-record-i/
 */
public class Demo_0818 {
    // 灵神
    public boolean checkRecord(String s) {
        int absent = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' && ++absent > 1) return false;
        }
        return !s.contains("LLL");
    }

    // 自己的答案
    // 总出勤 缺勤严格少于两天
    // 不存在连续3天或者以上的迟到记录
    public boolean checkRecord1(String s) {
        // PPALLP  A 缺勤  L 迟到  P 到场
        // 1. 统计A的个数
        // 2. 查找 "LLL" 的记录
        char[] chars = s.toCharArray();
        int absent = 0;
        int late = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                absent++;
                if (absent >= 2) return false;
            }
            // 如果当前为迟到
            if (chars[i] == 'L') {
                late++;
                if (late >= 3) return false;
                continue;
            }
            // 不连续则重置迟到天数
            late = 0;
        }
        return true;
    }
}