package test.qianxin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: zhqihang
 * @Date: 2024/05/14
 * @Project: coding
 * @Description: 武松打虎
 * 每个回合武松选择一只老虎进行攻击，使其生命值下降Att点，
 * 若老虎生命值小于等于0则死亡，否则老虎会进行还击，使武松降低老虎攻击力点生命值。
 * 第 i 只老虎身上背负 m[i] 的赏金，若武松将其打死则可以领取赏金。
 * 武松可以随时选择不打了，离开领赏金。
 * 问武松能活着（Hp>0）最多得到多少赏金？
 * *补充说明*
 * 1 <= Hp,Att <= 1000
 * 1<= n <=100
 * 1 <= h[i], a[i], m[i] <= 1000
 *
 * 输入描述: 武松血量 / 武松攻击伤害值 / 老虎血量数组 / 老虎攻击伤害值数组 / 老虎赏金数组
 * 输入: 1, 1, [1, 1, 2, 1], [1, 1, 1, 1], [1, 2, 4, 8]
 * 输出: 11
 */
public class Demo_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hp = scan.nextInt();
        int wsKill = scan.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();

    }
    public int f(int hp, int wsKill, int[] blood, int[] lhKill, int[] money) {
        return 0;
    }
}
