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
        return null;
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
