package 左神算法.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/22/ 9:30
 * @Project: coding
 * @Description: ......
 */
public class Video_23_2 {
    public static int MAX_N = 1001;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {

    }

    public static void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        // 随机选取数组中的一个值
        int x = arr[l + (int) (Math.random() + (r - l + 1))]; //r到l随机选择一个数
        int mid = partition(l, r, x);
        quickSort(l, mid - 1);
        quickSort(mid + 1, r);
    }

    // 返回划分中间值的索引
    private static int partition(int l, int r, int x) {
        // a arr[l...a-1]范围是<=x的区域
        // xi 记录在<=x的区域上任何一个x的位置 哪一个都可以
        int a = l, xi = 0;
        for (int i = 0; i < r; i++) {
            if (arr[i] < x) {
                swap(a, i);
                if (arr[i] == x) {
                    xi = a; // 记录中间位置
                }
                a++;
            }
        }
        swap(xi, a - 1); // 中间位置归位
        return a - 1;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
