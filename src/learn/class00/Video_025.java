package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/25/ 10:33
 * @Project: coding
 * @Description: 堆是特殊完全二叉树
 * 完全二叉树的高度是 log_2 n
 * <p>
 * 堆的调整复杂度为 O(logN)
 * <p>
 * 完全二叉树和数组前缀范围对应  用size管理边界
 * 节点的父节点是 i-1 / 2
 * 节点的左孩子是 i*2 + 1
 * 节点的右孩子是 i*2 + 2
 * <p>
 * 从顶到底建堆 O(N*logN)
 * 从低到顶建堆 O(N)  （大部分节点承担小层数）
 * 堆的调整复杂度为 O(logN)
 * 所以最终的复杂度都是O(N*logN)
 * 空间复杂度是O(1)
 * <p>
 * 经典堆排序
 * 升序：每次调整为大根堆 根节点和最后节点（--size）交换
 * 降序：每次调整为小根堆 根节点和最后节点（--size）交换
 * 重复 直到 size=0
 * 时间复杂度 O(N*logN)
 * 常量增倍法（子矩阵）
 */
public class Video_025 {
    public static void main(String[] args) {

    }
}
