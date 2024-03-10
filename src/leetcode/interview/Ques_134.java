package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/02/24
 * @Project: coding
 * @Description: 加油站
 * <p>
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class Ques_134 {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int i = canCompleteCircuit(gas, cost);
        System.out.println("i = " + i);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                //减去花费的加上新的点的补给
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
            //最远距离绕到了之前，所以 i 后边的都不可能绕一圈了
            if (j < i) {
                return -1;
            }
            //i 直接跳到 j，外层 for 循环执行 i++，相当于从 j + 1 开始考虑
            i = j;

        }
        return -1;
    }
    // 暴力解法

    public int canCompleteCircuit0(int[] gas, int[] cost) {
        int n = gas.length;
        // 尝试从每个节点出发
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i]; // 剩余汽油量
            // 当前剩余的油是否能到达下一点 不满足进入下一次for循环
            while (remain - cost[j] >= 0) {
                // 减去花费的加上新点的补给
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                if (j == i)
                    return i;
            }
        }
        return -1;
    }
    // 暴力解优化
    // 每考虑一个点 将当前点能到达的最远距离和到达之后的剩余汽油数进行记录

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;

        // 记录能到的最远距离
        int[] farIndex = new int[n];
        for (int i = 0; i < farIndex.length; i++) {
            farIndex[i] = -1;
        }

        // 记录到达最远距离时剩余的汽油
        int[] farIndexRemain = new int[n];

        // 尝试从每个节点出发
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                // 到达下个点的剩余
                remain = remain - cost[j];
                j = (j + 1) % n;
                // 判断之前有没有考虑这个点
                if (farIndex[j] != -1) { // 考虑过
                    // 加上当时剩余的汽油
                    remain += farIndexRemain[j];
                    // j直接进行跳跃
                    j = farIndex[j];
                } else {
                    // 没有考虑过
                    // 加上当前点的补给
                    farIndex[i] = j;
                    farIndexRemain[i] = remain;
                    remain += gas[j];
                }
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }
}