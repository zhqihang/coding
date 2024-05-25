package leetcode.hot100;

import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/25
 * @Project: coding
 * @Description: 排序链表
 * 给你链表的头结点 head，请将其按 升序 排列并返回 排序后的链表。
 * https://leetcode.cn/problems/sort-list/description
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */
public class Demo_148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针 寻找中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } // 此时slow指向链表中点

        // 将链表分为两部分
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;
        // 排序
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        // 合并
        h.next = left != null ? left : right;
        return res.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
