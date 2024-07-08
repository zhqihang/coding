package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/25
 * @Project: coding
 * @Description: 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * https://leetcode.cn/problems/add-two-numbers/description
 * <p>
 * 相加 还要倒序 还要考虑进位
 */
public class Demo_002 {
    // 新链表接受两个链表的值
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        // 答案链表 表头指针
        ListNode ans = null;
        // 当前指针
        ListNode cur = null;
        int carry = 0;

        // 遍历链表
        for (int sum, val;
             h1 != null || h2 != null;
             h1 = h1 == null ? null : h1.next, h2 = h2 == null ? null : h2.next
        ) {
            sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            // 判断是否有进位
            val = sum % 10;
            carry = sum / 10;

            // 存储和链表
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        // 还要判断最后一位有无进位
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
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
