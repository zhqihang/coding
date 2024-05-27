package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/26
 * @Project: coding
 * @Description: 删除链表的倒数第 n 个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Demo_019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哨兵节点
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right = dummy;
        while (n-- != 0) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }

    // 间隔为 n 的双指针移动到末尾
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode left = head, right = head;
        while (n-- != 0) {
            right = right.next;
        }
        // 有可能删除的是头结点
        if (right == null) return head.next;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
