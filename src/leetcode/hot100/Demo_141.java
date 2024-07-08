package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况
 * https://leetcode.cn/problems/linked-list-cycle/description
 * <p>
 * 解题思路:
 * 解法一: 双指针移动 如果相遇即有环
 * 解法二: 使用Set集合保存节点信息 遍历 如果遇到重复值 则有环
 */
public class Demo_141 {


    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.add(head)) {
                head = head.next;
                continue;
            }
            return true;
        }
        return false;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
