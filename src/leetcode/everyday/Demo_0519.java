package leetcode.everyday;

/**
 * @Author: zhqihang
 * @Date: 2024/05/19
 * @Project: coding
 * @Description: 找出数组游戏的赢家
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。
 * 比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。
 * 当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * 返回赢得比赛的整数。
 * 题目数据 保证 游戏存在赢家
 * https://leetcode.cn/problems/find-the-winner-of-an-array-game/description
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 * <p>
 * 解题思路:
 *      1.记录数组首位
 *      2.
 */
public class Demo_0519 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 10;
        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k) {
        int mx = arr[0];
        // 统计 mx 连续获胜回合
        int win = 0;
        // arr[1] 开始遍历数组
        for (int i = 1; i < arr.length && win < k; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
                win = 0;
            }
            win++;
        }
        return mx;
    }
}





