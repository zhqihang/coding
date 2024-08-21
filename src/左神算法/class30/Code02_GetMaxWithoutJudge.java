package 左神算法.class30;

/**
 * @Author: zhqihang
 * @Date: 2024/01/20
 * @Project: coding
 * @Description: 异或运算
 * <p>
 * 异或运算：无进位相加
 */
public class Code02_GetMaxWithoutJudge {

    // 不用任何比较语句和操作 返回两个数的最大值
    public int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffAB = sa ^ sb;
        int sameAB = flip(diffAB);
        int returnA = diffAB * sa + sameAB * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    private int sign(int n) {
        return flip(n >>> 31);
    }

    private int flip(int n) {
        return n ^ 1;
    }

}
