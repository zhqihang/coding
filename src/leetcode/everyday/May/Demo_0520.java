package leetcode.everyday.May;

import java.util.Arrays;

/**
 * @Author: zhqihang
 * @Date: 2024/05/20
 * @Project: coding
 * @Description: 找出最长的超赞子字符串
 * 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
 * 「超赞子字符串」需满足满足下述两个条件：
 * - 该字符串是 s 的一个非空子字符串
 * - 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
 * https://leetcode.cn/problems/find-longest-awesome-substring/description
 *
 * 解题思路: 前缀异或和 表示字母出现的次数奇偶性
 *
 *
 */
public class Demo_0520 {
    public static final int D = 10; // s 中字符的种类数
    public int longestAwesome(String s) {
        int n = s.length();
        // 初始化 异或前缀和 数组
        int[] pos = new int[1 << D];
        Arrays.fill(pos, n); // n 表示没有找到异或前缀和
        pos[0] = -1;
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre ^= 1 << (s.charAt(i) - '0');
            for (int d = 0; d < D; d++) {
                ans = Math.max(ans, i - pos[pre ^ (1 << d)]); // 奇数
            }
            ans = Math.max(ans, i - pos[pre]); // 偶数
            if (pos[pre] == n) { // 首次遇到值为 pre 的前缀异或和 记录其下标
                pos[pre] = i;
            }
        }
        return ans;
    }
}
