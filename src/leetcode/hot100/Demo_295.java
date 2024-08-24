package leetcode.hot100;

import java.util.PriorityQueue;

/**
 * @description: 数据流的中位数
 * @author: zhqihang
 * @date: 2024/08/22
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * https://leetcode.cn/problems/find-median-from-data-stream/description/
 * Demo_295 --> MedianFinder
 */
public class Demo_295 {
    /*
    大根堆 存储数据流中较小的一半
    小根堆 存储数据流中较大的一半
    中位数：由两个堆的堆顶元素获取
     */

    // 定义两个堆
    private PriorityQueue<Integer> maxHeap; // 大根堆
    private PriorityQueue<Integer> minHeap; // 小根堆

    // 初始化堆
    public Demo_295() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a)); // 比较器写法
        minHeap = new PriorityQueue<>((a, b) -> (a - b));
    }

    // 新增数字
    public void addNum(int num) {
        // 大根堆是空的（此时小根堆也空） 或者 该数字 小于等于 大根堆的堆顶
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num); // 入大根堆
        } else {
            minHeap.add(num); // 入小根堆
        }
        // 两个堆的元素个数差大于1（只会为2 因为只要超了就调整）则调整
        balance();
    }

    // 取中位数
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            // 数据为偶数 取平均值
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        // 数据为奇数 取多的那个
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }

    // 调整平衡两个堆
    void balance() {
        // 差值为2 看谁多 往对方移动一个
        if(Math.abs(maxHeap.size() - minHeap.size()) == 2) {
            if(maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }

}
