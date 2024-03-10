package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/08/ 9:39
 * @Project: coding
 * @Description: ......
 */
public class Video_013 {

    public int[] queue;

    public int l, r, size, limit;

    // 同时在队列里的数字个数，不要超过k
    public Video_013(int k) {
        queue = new int[k];
        l = r = size = 0;
        limit = k;
    }

    // 如果队列满了，什么也不做，返回false
    // 如果队列没满，加入value，返回true
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            queue[r] = value;
            // r++, 结束了，跳回0
            r = r == limit - 1 ? 0 : (r + 1);
            size++;
            return true;
        }
    }

    // 如果队列空了，什么也不做，返回false
    // 如果队列没空，弹出头部的数字，返回true
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            // l++, 结束了，跳回0
            l = l == limit - 1 ? 0 : (l + 1);
            size--;
            return true;
        }
    }

    // 返回队列头部的数字（不弹出），如果没有数返回-1
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[l];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            int last = r == 0 ? (limit - 1) : (r - 1);
            return queue[last];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

}
