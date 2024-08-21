package 左神算法.class00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: qihang
 * @CreateDate: 2023/12/26/ 17:41
 * @Project: coding
 * @Description: ......
 */
public class Video_027 {


    public static void main(String[] args) {

    }

    public static int halveArray(int[] nums) {
        // 大根堆
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            heap.add((double) num);
            sum += num;
        }
        sum /= 2;
        int ans = 0;
        // minus: 当前减少的总幅度
        for (double minus = 0, cur; minus < sum; ans++, minus += cur) {
            cur = heap.poll() / 2; // 当前减少的幅度 也是要入堆的数字
            heap.add(cur);
        }
        return ans;
    }


    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 重叠线段的数量
    // 重叠线段的左边界 一定是某个线段的左边界
    // 所有线段根据左边界排序  右边界不管
    // 依次小根堆中保存线段右边界(跳到下一个时, 弹出小于等于左边界的元素)
    // 小根堆中元素个数的最大值 = 重叠线段的数量

    public static int MAXN = 10001;

    public static int[][] line = new int[MAXN][2];

    public static int n;

    public static int compute() {
        // 清空栈
        size = 0;

        // 排序
        Arrays.sort(line, 0, n, (a, b) -> a[0] - b[0]);
        // 记录最大值
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 堆里有元素 并且元素小于此时左边界 弹出
            while (size > 0 && heap[0] <= line[i][0]) {
                pop();
            }
            // 当前线段的右边界加入堆中
            add(line[i][1]);
            ans = Math.max(ans, size);
        }
        return ans;
    }

    // 小根堆，堆顶0位置
    public static int[] heap = new int[MAXN];

    // 堆的大小
    public static int size;

    public static void add(int x) {
        heap[size] = x;
        int i = size++;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // 堆弹出
    public static void pop() {
        swap(0, --size);
        // 调整堆
        int i = 0, l = 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
            best = heap[best] < heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // 合并K个有序链表
    public static ListNode mergeKList(ArrayList<ListNode> arr) {
        // 小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 遍历头结点
        for (ListNode h : arr) {
            if (h != null) {
                heap.add(h);
            }
        }
        // 如果都是空链表 直接返回
        if (heap.isEmpty()) {
            return null;
        }
        // 拿到头结点
        ListNode h = heap.poll();
        ListNode pre = h;
        // 所有头结点入堆
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur; // 加入新链表
            pre = cur; // pre后移
            // 继续链表入堆
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return h;
    }
}
