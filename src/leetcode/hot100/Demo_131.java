package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/07/11
 * @Project: coding
 * @Description: 分割回文串
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Demo_131 {
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, 0);
        return ans;
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

    // start 表示当前这段回文子串的开始位置
    private void dfs(int i, int start) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path)); // 复制 path
            return;
        }

        // 不选 i 和 i+1 之间的逗号（i=n-1 时一定要选）
        if (i < s.length() - 1)
            dfs(i + 1, start);

        // 选 i 和 i+1 之间的逗号（把 s[i] 作为子串的最后一个字符）
        if (isPalindrome(start, i)) {
            path.add(s.substring(start, i + 1));
            dfs(i + 1, i + 1); // 下一个子串从 i+1 开始
            path.remove(path.size() - 1); // 恢复现场
        }
    }
}
