package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description
 *
 * 注意: 未考虑到 —— 遍历求长度差值时 如果到末尾都不相交 直接返回 null
 */
public class Demo_160 {
    // 双指针后移
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // 求出来链表长度差值 len
        ListNode a = headA;
        ListNode b = headB;
        int len = 0;
        while (a.next != null) {
            a = a.next;
            len++;
        }
        while (b.next != null) {
            b = b.next;
            len--;
        }
        // 如果到末尾都不相交 返回 null
        if (a != b) return null;

        // 看那个链表最长
        ListNode longList = null;
        ListNode shortList = null;
        if (len > 0) {
            longList = headA;
            shortList = headB;
        } else {
            longList = headB;
            shortList = headA;
        }
        // 长链表先走 len 步
        len = Math.abs(len);
        while (len-- != 0) {
            longList = longList.next;
        }
        // 一起往后走 直到相等 返回
        while (longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
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
