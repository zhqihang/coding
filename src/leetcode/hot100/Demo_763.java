package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 划分字母区间
 * @author: zhqihang
 * @date: 2024/08/24
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * https://leetcode.cn/problems/partition-labels/description
 */
public class Demo_763 {
    /*
    遍历字符串 s 计算字母 c 在 s 中的最后出现的下标 last[c]
    初始化当前正在合并的区间左右端点 start = 0 end = 0
    再次遍历 s 由于当前区间必须包含所有 s[i] 所以用 last[s[i]] 更新区间右端点 end 的最大值
    如果 发现 end = i 那么当前区间合并完毕 把区间长度 end-start+1 加入答案
    然后更新 start = i + 1 作为下一个区间的左端点
    遍历完毕 返回答案
    */
    // 合并区间
    public List<Integer> partitionLabels(String s) {
        // 答案列表
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> lastIndex = new HashMap<>(); // 字母最后出现的下标
        for (int i = 0; i < s.length(); i++) {
            // 遍历更新 字符：最后出现位置
            lastIndex.put(s.charAt(i), i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer last = lastIndex.get(s.charAt(i));
            end = Math.max(end, last); // 更新左边界
            // 当前区间合并完毕
            if (end == i) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
