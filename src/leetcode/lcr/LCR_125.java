package leetcode.lcr;

import java.util.LinkedList;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class LCR_125 {
    LinkedList<Integer> A, B;

    public LCR_125() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        // 分三种情况
        // 1. 栈B不为空，直接出栈B栈顶元素
        // 2. 栈B为空，栈A为空，返回-1
        // 3. 栈B为空，栈A不为空，栈A全部出栈 压入栈B，结束后弹出栈B栈顶元素
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1; // 能到这里 B就为空
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
