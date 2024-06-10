package leetcode.biweekly.wk132;

/**
 * @Author: zhqihang
 * @Date: 2024/06/09
 * @Project: coding
 * @Description: 401周赛
 * 给你两个 正整数 n 和 k。
 * 有 n 个编号从 0 到 n - 1 的孩子按顺序从左到右站成一队。
 * 最初，编号为 0 的孩子拿着一个球，并且向右传球。
 * 每过一秒，拿着球的孩子就会将球传给他旁边的孩子。
 * 一旦球到达队列的 任一端 ，即编号为 0 的孩子或编号为 n - 1 的孩子处，传球方向就会 反转 。
 * 返回 k 秒后接到球的孩子的编号
 * https://leetcode.cn/contest/weekly-contest-401/problems/find-the-child-who-has-the-ball-after-k-seconds/description/
 */
public class Demo_05 {

    public static void main(String[] args) {
        System.out.println(numberOfChild(3, 5));
        System.out.println(numberOfChild(5, 6));
        System.out.println(numberOfChild(4, 2));
        System.out.println(numberOfChild(2, 4));
    }

    public static int numberOfChild(int n, int k) {
        int cnt = 2 * (n - 1);
        int pos = k % cnt;
        if (pos < n) {
            return pos;
        } else {
            return cnt - pos;
        }
    }
}
