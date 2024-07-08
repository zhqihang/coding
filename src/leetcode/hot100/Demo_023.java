package leetcode.hot100;

import java.util.PriorityQueue;

/**
 * @Author: zhqihang
 * @Date: 2024/06/03
 * @Project: coding
 * @Description: 合并 k 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * https://leetcode.cn/problems/merge-k-sorted-lists/description
 */
public class Demo_023 {

    // 最小堆
    public ListNode mergeKLists(ListNode[] lists) {
        // 优先队列实现最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        // 哨兵节点 作为合并后链表头结点的前驱
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        // 循环到队空为止
        while (!pq.isEmpty()) {
            // 剩余节点中的最小节点
            ListNode node = pq.poll();
            // 下一个节点不为空
            if (node.next != null) {
                // 入堆
                pq.offer(node.next);
            }
            // 并入新链表中
            cur.next = node;
            // 指针后移 准备合并下一节点
            cur = cur.next;
        }
        return dummy.next;
    }


    public class ListNode {
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
