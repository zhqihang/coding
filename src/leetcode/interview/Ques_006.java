package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/02/26
 * @Project: coding
 * @Description: Z字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 */
public class Ques_006 {
    // 二维矩阵模拟
    // Z字变换的周期 t = numRows + numRows - 2
    // 每个周期占 1 + numRows - 2 列
    // 对于 n 长的字符串 有 n/t(向上取整)个周期
    // 所以列数为  n/t(向上取整) * (numRows - 1)
    // 创建二维矩阵 遍历字符串 按照Z字形进行填写
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows > n) {
            return s;
        }
        int t = 2 * numRows - 2;
        // 这里注意向上取整
        // 代码除法默认向下取整，向上取整：（a+b-1）/ b
        int c = (n + t - 1) / t * (numRows - 1); // 列数
        char[][] mat = new char[numRows][c];

        int x = 0, y = 0; // 初始位置
        for (int i = 0; i < n; i++) {
            mat[x][y] = s.charAt(i);

            if ((i % t) < (numRows - 1)) {
                // 向下移动
                x++;
            } else {
                // 右上移动
                x--;
                y++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] row : mat) {
            for (char ch : row) {
                // char 默认值为"空字符"，即’\u0000’，数值为0
                if (ch != 0)
                    sb.append(ch);
            }
        }
        return sb.toString();
    }
}
