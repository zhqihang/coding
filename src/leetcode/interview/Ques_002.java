package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/01/16
 * @Project: coding
 * @Description: 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。
 * <p>
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Ques_002 {

    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        ListNode ans = null, cur = null;
        int carry = 0;
        for (int sum, val;
             h1 != null || h2 != null;
             h1 = h1 == null ? null : h1.next, h2 = h2 == null ? null : h2.next
        ) {
            sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            val = sum % 10;
            carry = sum / 10;

            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }

    public static class ListNode {
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
