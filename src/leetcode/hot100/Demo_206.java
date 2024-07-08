package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * https://leetcode.cn/problems/reverse-linked-list/description
 */
public class Demo_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null; // 前置节点
        ListNode next = null; // 后置节点
        // head 遍历后移 翻转指针
        while (head != null) {
            next = head.next; // 记住下一个的位置
            head.next = pre; // 翻转指针 指向本来的前置节点
            pre = head; // 记住当前位置
            head = next; // head后移
        }
        return pre;
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
