package leetcode.code;

/**
 * @Author: zhqihang
 * @Date: 2024/06/02
 * @Project: coding
 * @Description: 删除排序链表中的重复元素2
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class Demo_0082 {

    public ListNode deleteDuplicates(ListNode head) {
        // 哨兵 记录头指针位置
        ListNode dummy = new ListNode(0, head), cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            // 如果相等
            if (cur.next.next.val == val)
                // 删除所有相等的节点
                while (cur.next != null && cur.next.val == val)
                    cur.next = cur.next.next;
                // 如果不相等 向后便遍历
            else
                cur = cur.next;
        }
        return dummy.next;
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
