package leetcode.hot100;

/**
 * @description: 寻找重复数
 * @author: zhqihang
 * @date: 2024/08/24
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * https://leetcode.cn/problems/find-the-duplicate-number/description
 */
public class Demo_287 {
    /*
    数组想象成单链表 --> 寻找入环节点 --> 快慢指针
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        // 快慢指针遍历链表
        int slow = nums[0], fast = nums[nums[0]]; // 初始化
        while (slow != fast) {
            slow = nums[slow]; // 慢指针走一步
            fast = nums[nums[fast]]; // 快指针走两步
        }
        // 相遇后 fast回到起点 两个指针一次走一步 相遇时为入环节点
        fast = 0; // 相当于头结点
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
