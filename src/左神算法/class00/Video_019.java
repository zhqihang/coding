package 左神算法.class00;

import java.io.*;

/**
 * @author: qihang
 * @CreateDate: 2023/12/18/ 14:01
 * @Project: coding
 * @Description: 算法笔试中处理输入输出
 * <p>
 * 力扣牛客属于填函数风格
 * acm蓝桥的输入
 * 使用BufferReader读取文件 建立内存托管
 * 输出文件时使用PrintWriter先托管所有数据  最后flush
 * 不推荐临时动态空间
 * 推荐全局静态空间
 * 使用静态代码建立空间(max 最大空间题目一般会给) 进行复用 避免多次申请
 */
public class Video_019 {

    public static void main(String[] args) throws IOException {
        // 从标准输入读取字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 将字符流分词为标记
        StreamTokenizer in = new StreamTokenizer(br);

        // 用于向标准流写入字符流
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // 循环读入
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // 字符流的词长度  先输入数组长度 然后是数组内容
            int n = (int) in.nval;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush(); // 一定记得关闭和刷新输入流
        out.close();
    }
}
