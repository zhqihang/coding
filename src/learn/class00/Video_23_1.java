package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/20/ 10:31
 * @Project: coding
 * @Description: 随机快速排序：
 * 经典随机快排：一次确定一个元素的中间位置
 * 荷兰国旗问题：一次确定数值相同的若干个值的中间位置
 * 时间复杂度均为 O(n*log n)
 *
 * 分析随机行为的时间复杂度时，需要用期望行为 不能用最坏情况
 *
 */
public class Video_23_1 {

    public static int MAX_N = 1001;
    public static int[] arr = new int[MAX_N];

    public static int first, last;

    public static void main(String[] args) {

    }

    // 荷兰国旗问题快排
    public static void quickSort(int l, int r) {
        if (l >= r) return;
        // 随机选取数组中的一个值
        int x = arr[l + (int) (Math.random() + (r - l + 1))]; //r到l随机选择一个数
        partition(l, r, x);
        // 临时变量记录 防止递归覆盖
        int left = first;
        int right = last;
        quickSort(l, left - 1);
        quickSort(right + 1, r);
    }

    // 返回划分中间值的索引
    private static void partition(int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i < last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(first++, i++);
            } else {
                swap(i, last--);
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
