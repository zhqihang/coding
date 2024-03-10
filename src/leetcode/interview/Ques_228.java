package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/01/15
 * @Project: coding
 * @Description: 汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 */
public class Ques_228 {

    // 快慢指针
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int slow = 0;
        int len = nums.length;
        for (int fast = 0; fast < len; fast++) {
            // 两个写入条件
            // 1. fast到达数组末尾
            // 2. 不连续点
            if (fast + 1 == len || nums[fast] + 1 != nums[fast + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[slow]);
                if (slow != fast) {
                    sb.append("->").append(nums[fast]);
                }
                list.add(sb.toString());
                slow = fast + 1;
            }
        }
        return list;
    }
}
