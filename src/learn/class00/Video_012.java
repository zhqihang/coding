package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/08/ 8:47
 * @Project: coding
 * @Description: ......
 */
public class Video_012 {


    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        ListNode next = null;

        // 终止条件
        while (head != null) {
            next = head.next; //记录一下下一位置 因为要断链
            head.next = null;
            // 小于范围
            if (head.val < x) {
                // set head
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                // set tail
                leftTail = head;
            // 大于范围
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next; // 处理下一节点
        }
        // 默认返回左头 这里对左头进行判断
        // 如果没有小于的 直接返回右头结点
        if (leftHead == null){
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }

    // 单链表节点
    public static class ListNode {
        public int val;
        public Video_012.ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, Video_012.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
