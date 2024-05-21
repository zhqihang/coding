package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 统计已测试设备
 * 给你一个长度为 n 、下标从 0 开始的整数数组 batteryPercentages，表示 n 个设备的电池百分比。
 * 你的任务是按照顺序测试每个设备 i，执行以下测试操作：
 * - 如果 batteryPercentages[i] 大于 0：
 *   - 增加 已测试设备的计数
 *   - 将下标在[i+1,n-1]的所有设备的电池百分比减少 1，确保它们的电池百分比不会低于 0, 即 batteryPercentages[j]=max(0,batteryPercentages[j]-1)
 *   - 移动到下一个设备。
 * - 否则，移动到下一个设备而不执行任何测试。
 *
 * 返回一个整数，表示按顺序执行测试操作后 已测试设备 的数量。
 * https://leetcode.cn/problems/count-tested-devices-after-test-operations
 *
 *
 */
public class Demo_0510 {

    public int countTestedDevices(int[] arr) {
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] - ans> 0) {
                ans++;
                // 并不能知道 i 位置后面的情况 所以只需要记录 减一 的次数 (也就是 ans)
                // 所以只要判断 arr[i] - ans > 0 就可以
                // Arrays.fill(arr, i, n - 1, Math.max(0, arr[i] - 1));
            }
        }
        return ans;
    }
}
