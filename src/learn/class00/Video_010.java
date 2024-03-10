package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/06/ 21:26
 * @Project: coding
 * @Description: 合并两个有序链表
 */
public class Video_010 {

    class Solution {
        public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
            if (head1 == null || head2 == null) {
                return head1 == null ? head2 : head1;
            }

            ListNode head = head1.val <= head2.val ? head1 : head2; //谁小谁做头
            ListNode cur1 = head.next;
            ListNode cur2 = head == head1 ? head2 : head1; // 指向另一个链表
            ListNode pre = head; // 挂好节点的前一个

            // 都没完 谁小谁挂在pre之后
            while (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    pre.next = cur1;
                    cur1 = cur1.next;
                } else {
                    pre.next = cur2;
                    cur2 = cur2.next;
                }
                pre = pre.next;
            }
            pre.next = cur1 != null ? cur1 : cur2; //剩余部分
            return head;
        }
    }

    // 单链表节点
    public static class ListNode {
        public int val;
        public Video_010.ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, Video_010.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
