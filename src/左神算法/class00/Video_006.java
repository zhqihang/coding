package 左神算法.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/04/ 14:36
 * @Project: coding
 * @Description: 二分搜索
 */
public class Video_006 {

    // 寻找峰值
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        int l = 1, r = n - 2, m = 0, ans = -1;
        while (l <= r) {
            // m = l + ((r - l) >> 2);
            m = l + ((r - l) >> 1);
            if (arr[m - 1] > arr[m]) {
                r = m - 1;
            } else if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }
        }
        return ans;
    }

    //有序数组找小于等于 num 的最右位置
    public static int findRight(int[] arr, int num) {
        if (arr == null) {
            return -1;
        }
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r) {
            // 中点位置
            m = l + ((r - l) >> 1);

            if (num < arr[m]) {
                r = m - 1;
            } else if (num >= arr[m]) {
                ans = m; // 这个范围内 临时满足条件的位置 需要继续二分
                l = m + 1;
            }
        }
        return ans;
    }


    //有序数组找大于等于num的最左位置
    public static int findLeft(int[] arr, int num) {
        if (arr == null) {
            return -1;
        }
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r) {
            m = (l + r) / 2;
            // m = l + ((r - l) >> 1);  l加一半距离等价于相加除二，数组很长时 防止溢出
            if (arr[m] >= num) {
                ans = m;
                r = m - 1;
            } else if (arr[m] < num) {
                l = m + 1;
            }
        }
        return ans;
    }


    //有序数组二分查找 num是否存在
    public static boolean exist(int[] arr, int num) {
        if (arr == null) {
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

}
