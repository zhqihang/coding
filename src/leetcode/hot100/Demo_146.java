package leetcode.hot100;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/06/03
 * @Project: coding
 * @Description: LRU 缓存
 * https://leetcode.cn/problems/lru-cache/description/
 * <p>
 * 双向链表实现
 */
public class Demo_146 {

    // 双向链表节点
    class DoubleNode {
        public int key;
        public int val;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    // 双向链表
    class DoubleList {
        private DoubleNode head;
        private DoubleNode tail;

        public DoubleList() {
            head = null;
            tail = null;
        }

        // 新增节点
        public void addNode(DoubleNode newNode) {
            if (newNode == null) {
                return;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.last = tail;
                tail = newNode;
            }
        }

        // 移动节点到尾部
        public void moveNodeToTail(DoubleNode node) {
            if (tail == node) {
                return;
            }
            if (head == node) {
                head = node.next;
                head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

        // 删除头结点
        public DoubleNode removeHead() {
            if (head == null) {
                return null;
            }
            DoubleNode ans = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = ans.next;
                ans.next = null;
                head.last = null;
            }
            return ans;
        }
    }

    // 哈希表
    private HashMap<Integer, DoubleNode> keyNodeMap;

    private DoubleList nodeList;

    private final int capacity;

    // LRUCache
    public Demo_146(int cap) {
        keyNodeMap = new HashMap<>();
        nodeList = new DoubleList();
        capacity = cap;
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            DoubleNode ans = keyNodeMap.get(key);
            nodeList.moveNodeToTail(ans);
            return ans.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            DoubleNode node = keyNodeMap.get(key);
            node.val = value; // 更新节点的值
            nodeList.moveNodeToTail(node); // 更新时序信息
        } else {
            // 空间不足 执行LRU算法
            if (keyNodeMap.size() == capacity) {
                keyNodeMap.remove(nodeList.removeHead().key);
            }
            // 新建节点
            DoubleNode newNode = new DoubleNode(key, value);
            // 写入哈希表
            keyNodeMap.put(key, newNode);
            // 写入双向链表
            nodeList.addNode(newNode);
        }
    }
}
