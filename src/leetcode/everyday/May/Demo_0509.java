package leetcode.everyday.May;

/**
 * @Author: zhqihang
 * @Date: 2024/05/09
 * @Project: coding
 * @Description: 给植物浇水
 * https://leetcode.cn/problems/watering-plants-ii/description/
 * <p>
 * Alice 和 Bob 打算给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。其中，第 i 株植物的位置是 x = i 。
 * <p>
 * 每一株植物都需要浇特定量的水。Alice 和 Bob 每人有一个水罐，最初是满的 。他们按下面描述的方式完成浇水：
 * <p>
 * 1. Alice 按 从左到右 的顺序给植物浇水，从植物 0 开始。Bob 按 从右到左 的顺序给植物浇水，从植物 n - 1 开始。他们 同时 给植物浇水。
 * 2. 无论需要多少水，为每株植物浇水所需的时间都是相同的。
 * 3. 如果 Alice/Bob 水罐中的水足以 完全 灌溉植物，他们 必须 给植物浇水。否则，他们 首先（立即）重新装满罐子，然后给植物浇水。
 * 4. 如果 Alice 和 Bob 到达同一株植物，那么当前水罐中水 更多 的人会给这株植物浇水。如果他俩水量相同，那么 Alice 会给这株植物浇水。
 * <p>
 * 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。
 * 另有两个整数 capacityA 和 capacityB 分别表示 Alice 和 Bob 水罐的容量。
 * 返回两人浇灌所有植物过程中重新灌满水罐的 次数 。
 * <p>
 * 思路: 双指针模拟过程
 */
public class Demo_0509 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        // 初始化剩余水量
        int a = capacityA, b = capacityB;
        int n = plants.length;
        int l = 0, r = n - 1;
        while (l < r) {
            // 对于 Alice 的模拟
            if (a < plants[l]) {
                a = capacityA; // 灌满水
                ans++;
            }
            a -= plants[l++]; // 浇水

            // 对于 Bob 的模拟
            if (b < plants[r]) {
                b = capacityB; // 灌满水
                ans++;
            }
            b -= plants[r--]; // 浇水
        }
        // Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水
        if (l == r && Math.max(a, b) < plants[l]) {
            ans++;
        }
        return ans;
    }
}
