package leetcode.lcr;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/description/
 */
public class LCR_120 {
    public int findRepeatDocument(int[] documents) {
        // 寻找数组中的重复元素
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < documents.length; i++) {
            if (map.containsKey(documents[i]))
                return documents[i];
            else
                map.put(documents[i], i);
        }
        return -1;
    }
}
