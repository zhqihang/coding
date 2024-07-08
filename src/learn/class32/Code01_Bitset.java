package learn.class32;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/01/31
 * @Project: coding
 * @Description: 位图的实现
 */
public class Code01_Bitset {

    public static void main(String[] args) {
        int n = 1000;
        int testTimes = 10000;
        System.out.println("开始测试");
        // 实现位图的结构
        Bitset bitset = new Bitset(n);
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("调用阶段开始！");
        for (int i = 0; i < testTimes; i++) {
            double decide = Math.random();
            int number = (int) (Math.random() * n);
            if (decide < 0.33) {
                bitset.add(number);
                hashSet.add(number);
            } else if (decide < 0.666) {
                bitset.remove(number);
                hashSet.remove(number);
            } else {
                bitset.reverse(number);
                if (hashSet.contains(number)) {
                    hashSet.remove(number);
                } else {
                    hashSet.add(number);
                }
            }
        }
        System.out.println("调用阶段结束");
        System.out.println("验证阶段开始");
        for (int i = 0; i < n; i++) {
            if (bitset.contains(i) != hashSet.contains(i)) {
                System.out.println("出错了！");
            }

        }
        System.out.println("验证阶段结束！");
        System.out.println("测试结束");
    }

    // 位图的实现
    public static class Bitset {

        public int[] set;

        // n个数字：0~n-1
        public Bitset(int n) {
            // a/b如果结果想向上取整，可以写成 : (a+b-1)/b
            // 前提是a和b都是非负数
            set = new int[(n + 31) / 32];
        }

        public void add(int num) {
            // num位于 num / 32 的位置上
            set[num / 32] |= 1 << (num % 32); // 某位要置1
        }

        public void remove(int num) {
            // 取反 再 与
            set[num / 32] &= ~(1 << (num % 32)); // 某位要置0
        }

        // 改变某一位的状态 0 -- 1
        public void reverse(int num) {
            set[num / 32] ^= 1 << (num % 32);
        }

        // 查看数字状态 等于1存在 等于0不存在
        public boolean contains(int num) {
            return ((set[num / 32] >> (num % 32)) & 1) == 1;
        }
    }
}
