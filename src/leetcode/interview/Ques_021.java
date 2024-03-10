package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/17
 * @Project: coding
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成。
 */
public class Ques_021 {

    // 链表指针
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        // 判断 head指针的位置 最后需要返回head
        ListNode head = head1.val >= head2.val ? head2 : head1;

        // 两个比较指针
        ListNode cur1 = head.next;
        ListNode cur2 = head1.next == cur1.next ? head2 : head1;

        // 新链表构建的 pre 指针
        ListNode pre = head;

        // 循环判断
        while (cur1 != null || cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }


    public static class ListNode {
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
