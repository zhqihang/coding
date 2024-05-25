package leetcode.hot100;

import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/25
 * @Project: coding
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * https://leetcode.cn/problems/merge-two-sorted-lists/description
 *
 */
public class Demo_021 {

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        // 开始合并操作
        // 小的链表开头 作为起始点
        ListNode head = head1.val <= head2.val ? head1 : head2;
        // 两个链表的指针
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1; // 连接节点
                cur1 = cur1.next; // 后移旧链表指针
            } else {
                pre.next = cur2; // 连接节点
                cur2 = cur2.next; // 后移旧链表指针
            }
            pre = pre.next; // 后移新链表指针 继续遍历
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
