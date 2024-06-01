package leetcode.everyday.May;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 给植物浇水
 * 你打算用一个水罐给花园里的 n 株植物浇水。
 * 植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。
 * 其中，第 i 株植物的位置是 x = i 。x = -1 处有一条河，你可以在那里重新灌满你的水罐。
 * 每一株植物都需要浇特定量的水。你将会按下面描述的方式完成浇水：
 *      1. 按从左到右的顺序给植物浇水。
 *      2. 在给当前植物浇完水之后，如果你没有足够的水 完全 浇灌下一株植物，那么你就需要返回河边重新装满水罐。
 *      3. 你 不能 提前重新灌满水罐。
 * 最初，你在河边（也就是，x = -1），在 x 轴上每移动 一个单位 都需要 一步 。
 * 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。
 * 其中，plants[i] 为第 i 株植物需要的水量。
 * 另有一个整数 capacity 表示水罐的容量，返回浇灌所有植物需要的 步数 。
 * https://leetcode.cn/problems/watering-plants/description/
 *
 */
public class Demo_0508 {
    // 数组 模拟
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int ans = 0;
        int residual = capacity; // 水罐剩余水量
        // 遍历浇水
        for (int i = 0; i < n; i++) {
            ans++; // 不管浇不浇得了水 得先先到了才知道
            if (plants[i] <= residual) {
                residual -= plants[i]; // 浇水
            } else {
                // 灌水
                residual = capacity;
                // 更新步数
                ans += 2 * i;
                // 浇水
                residual -= plants[i];
            }
        }
        return ans;
    }
}
