package leetcode.hot100;

import java.util.HashSet;
import java.util.List;

/**
 * @description: 单词拆分
 * @author: zhqihang
 * @date: 2024/09/03
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Demo_139 {
    // 单词拼接
    // 优化动态规划 双层循环
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            // 遍历所有可能的起始位置
            for (int j = 0; j < i; j++) {
                // 前j个字符可以由字典拼接 && 字典中包含 j-i 的子串
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true; // 设置为 true
                    break;
                }
            }
        }
        return dp[length];
    }


    // 动态规划
    public boolean wordBreak1(String s, List<String> wordDict) {
        int length = s.length();
        // 布尔数组
        // dp[i] 表示前 i 个字符是否可以由字典中的单词拼接而成
        boolean[] dp = new boolean[length + 1];
        dp[0] = true; // 长度为 0 的字符 可以满足
        // 遍历 s 的每个长度
        for (int i = 1; i <= length; i++) {
            // 尝试每个短字符串
            for (String word : wordDict) {
                int n = word.length();
                // 最开始的几个外层循环不会进这个 if
                // 直到 i - n > 0 && 当前单词可以拼接成子串 && 子串的前缀可以完成拼接
                if (i - n >= 0 && s.substring(i - n, i).equals(word) && dp[i - n] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
