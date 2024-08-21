package 左神算法.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/06/ 20:59
 * @Project: coding
 * @Description: 单双链表及其反转
 */

public class Video_009 {


    class Solution {

        // 反转链表 返回值为新头部
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;

            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

            return head;
        }
    }

    // 单链表节点
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
