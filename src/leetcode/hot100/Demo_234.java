package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/21
 * @Project: coding
 * @Description: 回文链表
 * 给你一个单链表的头节点 head，请你判断该链表是否为回文链表。
 * 如果是，返回 true；否则，返回 false
 * https://leetcode.cn/problems/palindrome-linked-list/description
 * 思路: 快慢指针找出链表中点
 * 从中点开始 翻转后面的链表
 * 然后从开头和结尾开始 往中间逐个比较 如果某一步不一样返回false
 * 最后恢复链表 返回结果
 */
public class Demo_234 {

    public static boolean isPalindrome(ListNode head) {
        // 为空 或者 单个节点 直接为 true
        if (head == null || head.next == null) return true;

        // 快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;
        // 这里第一个条件不能判断 slow.next != null
        // 因为 当 fast 走到末尾时 fast.next(null) 没有next属性
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } // 结束时 slow 即为链表中点

        // 翻转后半部分链表
        ListNode pre = slow;
        ListNode cur = slow.next; // 翻转指针不包含 slow !!!
        ListNode next = null;
        pre.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur; // 记住当前位置
            cur = next;
        } // 现在链表是 head -> ... -> slow <- ... <- pre

        // 从链表两头往中间比对 不相等返回false
        ListNode left = head;
        ListNode right = pre;
        boolean ans = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                ans = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        // 恢复链表 (翻转链表)
        cur = pre.next;
        pre.next = null;
        next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
