package leetcode.lcr;

/**
 * @Author: zhqihang
 * @Date: 2024/05/09
 * @Project: coding
 * @Description: 交易逆序数
 */
public class LCR_170 {

    public static int[] help;

    public int reversePairs(int[] record) {
        int n = record.length;
        help = new int[n];
        return mergeSort(record,0, n - 1);
    }

    private int mergeSort(int[] record, int l, int r) {
        // 递归出口
        if (l >= r) return 0;

        // 递归划分 同时记录逆序对数
        int m = l + ((r - l) >> 1);
        //           左数组递归                  右数组递归
        int res = mergeSort(record, l, m) + mergeSort(record, m + 1, r);
        // 合并阶段
        // i 和 j 分别代表 两个待合并数组的开头
        int i = l, j = m + 1;
        // 拷贝 l--r 到辅助数组
        for (int k = l; k <= r; k++) {
            help[k] = record[k];
        }
        // 遍历开始
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                // 此时 左数组已经合并完 添加右数组当前元素(排序)
                record[k] = help[j++];
            } else if (j == r + 1 || help[i] <= help[j]) {
                // 右数组合并完 || 左小于右时(满足 不存在逆序) 添加左数组当前元素(排序)
                record[k] = help[i++];
            } else {
                // help[i] > help[j] 的情况 左大于右 添加右数组当前元素(排序)
                record[k] = help[j++];
                // 统计逆序对
                // l ~ m 是升序的 所以当 i 大于右数组当前元素时 i后面的都大于
                // 即从i~m位置的每个数都大于右数组当前元素
                res += m - i + 1;
            }
        }
        return res;
    }
}
