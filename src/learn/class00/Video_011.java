package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/06/ 21:49
 * @Project: coding
 * @Description: ......
 */
public class Video_011 {

    class Solution {

        // 也可以复用老链表
        // 不过这个实现没有这么做，都是生成的新节点(为了教学好懂)
        public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
            ListNode ans = null, cur = null;
            int carry = 0; //进位数  加法只能为 0 或者 1
            for (int sum, val; // 声明变量
                 h1 != null || h2 != null; // 终止条件
                 h1 = h1 == null ? null : h1.next, // 每一步h1的跳转
                         h2 = h2 == null ? null : h2.next // 每一步h2的跳转
            ) {

                sum = (h1 == null ? 0 : h1.val)
                        + (h2 == null ? 0 : h2.val)
                        + carry;

                val = sum % 10; // 个位
                carry = sum / 10; // 进位
                if (ans == null) {
                    ans = new ListNode(val);
                    cur = ans;
                } else {
                    cur.next = new ListNode(val);
                    cur = cur.next;
                }
            }

            // 判断最后一位有无进位  若有则挂 1 节点
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return ans;
        }
    }


    // 单链表节点
    public static class ListNode {
        public int val;
        public Video_011.ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, Video_011.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
