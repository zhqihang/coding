package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 环形链表2
 * 给定一个链表的头节点 head, 返回链表开始入环的第一个节点。
 * 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 * https://leetcode.cn/problems/linked-list-cycle-ii/description
 *
 * 注意: 返回进入环的第一个节点
 *
 * 解法一: 使用集合记录节点 重复时返回
 * 解法二: 双指针
 */
public class Demo_142 {

    public ListNode detectCycle1(ListNode head) {
        if (head == null) return head;
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.add(head)) {
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 此时遇到环 从快指针 和 头一起开始遍历
                // 相遇时即为入环节点
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
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
