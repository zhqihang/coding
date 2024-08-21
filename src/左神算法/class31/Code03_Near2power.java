package 左神算法.class31;

/**
 * @Author: zhqihang
 * @Date: 2024/01/22
 * @Project: coding
 * @Description: 已知n是非负数
 * 返回大于等于n的最小的2某次方
 * 如果int范围内不存在这样的数，返回整数最小值
 */
public class Code03_Near2power {
    public static void main(String[] args) {
        int num = 136;
        System.out.println(near2power(num));
    }

    public static int near2power(int n) {
        if (n <= 0) {
            return 1;
        }
        n--;
        // n-- 之后的第一个 1 的右边全刷为 1
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return n + 1;
    }
}
