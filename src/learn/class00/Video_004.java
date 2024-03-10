package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/04/ 13:24
 * @Project: coding
 * @Description: 三傻排序
 */
public class Video_004 {

    // 交换数组元素
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[temp];
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0, minIndex; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // i 右边界
        for (int i = 1; i < arr.length; i++) {
            // 0 ~ i-1 位置已经有序 新来的数是arr[i],和左边比
            // j+1 是当前数  j是前一个数   若 j > j+1 停止
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) { //1. 到最左边-->停 2.不比左边小-->停
                swap(arr, j, j + 1);
            }
        }
    }
}
