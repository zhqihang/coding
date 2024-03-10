package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/30
 * @Project: coding
 * @Description: 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Ques_070 {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    // 动态规划
    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
