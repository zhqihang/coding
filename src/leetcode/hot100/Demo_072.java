package leetcode.hot100;

/**
 * @description: 编辑距离
 * @author: zhqihang
 * @date: 2024/09/04
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * https://leetcode.cn/problems/edit-distance/description/
 */
public class Demo_072 {
    public int minDistance(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int n = s.length;
        int m = t.length;
        int[][] f = new int[2][m + 1];
        for (int j = 1; j <= m; j++) {
            f[0][j] = j;
        }
        for (int i = 0; i < n; i++) {
            f[(i + 1) % 2][0] = i + 1;
            for (int j = 0; j < m; j++) {
                f[(i + 1) % 2][j + 1] = s[i] == t[j] ? f[i % 2][j] :
                        Math.min(Math.min(f[i % 2][j + 1], f[(i + 1) % 2][j]), f[i % 2][j]) + 1;
            }
        }
        return f[n % 2][m];
    }
}