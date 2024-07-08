package leetcode.hot100;

import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/05/28
 * @Project: coding
 * @Description: k个一组反转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description
 */
public class Demo_025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = teamEnd(start, k);
        if (end == null) return head;

        head = end; // 第一组翻转前的尾 是 结果 的头指针
        reverse(start, end); // 翻转 start -- end 的链表
        ListNode lastTeamEnd = start;
        // 还有下一组
        while (lastTeamEnd.next != null) {
            // 翻转
            start = lastTeamEnd.next;
            end = teamEnd(start, k);
            // 此时最后一组只有一个节点 不用翻转 直接结束
            if (end == null) return head;
            reverse(start, end);
            // 不同组之间的链接
            lastTeamEnd.next = end; // 上一组的末尾 指向 当前组反转后的 end
            lastTeamEnd = start; // 更新 开始处理下一组
        }
        return head;
    }

    private void reverse(ListNode start, ListNode end) {
        end = end.next; // 记录翻转前 尾指针后继
        ListNode pre = null, cur = start, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end; // 更新翻转后 尾指针后继
    }

    // 获取一组的最后一个节点 (考虑最后一组长度不满足 k)
    private ListNode teamEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
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
