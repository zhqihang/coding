package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/12
 * @Project: coding
 * @Description: 判断 s是否为 t的子序列
 */
public class Ques_392 {

    // 双指针
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}