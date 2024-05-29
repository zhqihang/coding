package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/28
 * @Project: coding
 * @Description: k个一组反转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description
 *
 */
public class Demo_025 {

    public ListNode reverseKGroup(ListNode head, int k) {


        return null;
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
