package leetcode.interview;

import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: zhqihang
 * @Date: 2024/01/15
 * @Project: coding
 * @Description: 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 02 = 1
 */
public class Ques_202 {

    public static boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        // 终止条件：
        // 1. fastRunner = 1     true
        // 2. slowRunner = fastRunner   false
        while (fastRunner != 1 && slowRunner != fastRunner){
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }


    // 哈希集合判断是否进入循环
    public static boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();

        // 循环的条件：n不等于1 并且n 不在集合中
        // n = 1 是快乐数
        // n 在集合中，则进入无限循环
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int total = 0;
        while (n > 0){
            int d = n % 10;
            n = n /10;
            total += d * d;
        }
        return total;
    }
}
