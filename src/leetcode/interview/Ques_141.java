package leetcode.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhqihang
 * @Date: 2024/01/16
 * @Project: coding
 * @Description: 环形链表
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class Ques_141 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(node1));
    }

    // 哈希表 记录节点是否被访问过
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.add(head))
                head = head.next;
            else
                return false;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        // 只要不相等就循环
        // 循环中判断是否return
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    // 快慢指针
    public static boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}


