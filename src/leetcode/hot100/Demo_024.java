package leetcode.hot100;

import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/25
 * @Project: coding
 * @Description: 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description
 */
public class Demo_024 {

    public ListNode swapPairs(ListNode head) {
        // 哨兵节点
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        // 至少有两个节点
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            // 交换指针方向
            node0.next = node2;
            node2.next = node1;
            node1.next = node3;
            // 后移继续操作
            node0 = node1;
            node1 = node3;
        }
        return dummy.next;
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
