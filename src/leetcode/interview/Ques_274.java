package leetcode.interview;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/02/24
 * @Project: coding
 * @Description: ...
 */
public class Ques_274 {

    // 一名科研人员的h指数是指他至少发表了h篇至少被引用h次的论文


    // 二分搜索
    // 满足 有h篇论文的引用次数至少为h
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        int mid = 0, cnt = 0;

        // 二分查找
        while (left < right) {
            // +1 防止死循环
            mid = (left + right + 1) >> 1;
            cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    cnt++;
                }
            }

            if (cnt >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 排序 从后向前遍历
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
