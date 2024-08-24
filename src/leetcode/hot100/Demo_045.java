package leetcode.hot100;

/**
 * @description: 跳跃游戏2
 * @author: zhqihang
 * @date: 2024/08/24
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * https://leetcode.cn/problems/jump-game-ii/description
 */
public class Demo_045 {

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 1, 4};

        System.out.println(jump(ints));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int end = 0; // 能跳到的最远位置
        int maxPosition = 0; // 当前范围内 下次最远可以到达的位置（下次起跳点）
        int steps = 0; //步数
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); // 更新最远到达位置
            if (i == end) {
                // 更新最远位置边界
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
