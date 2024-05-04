package leetcode.lcr;

import java.util.ArrayList;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/description/
 */
public class LCR_123 {
    // 反转链表
    public int[] reverseBookList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        ArrayList<Integer> list = new ArrayList();
        // 注意这里head为空 pre指向最后一个节点
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
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
