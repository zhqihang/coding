package leetcode.hot100;

import java.lang.invoke.VarHandle;

/**
 * @Author: zhqihang
 * @Date: 2024/05/08
 * @Project: coding
 * @Description: 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 思路:
 * 遍历 tar 字符数组 维护一个 “欠债表”
 * 整型数组和 总欠债 即 tar 的长度
 * 先向右探测 满足 tar 之后，记录此时长度  然后试探左侧是否可以缩短
 * <p>
 * 欠债表 记账 还账都会更新 记账用于尝试是否能够缩短左侧
 * 如果 此时 cnts[sChar[l]] 大于0 表示 这个字母是多余的 可以淘汰
 * 左移左指针 继续判断
 */
public class Demo_076 {

    public String minWindow(String str, String tar) {
        if (str.length() < tar.length()) return "";
        char[] sChar = str.toCharArray();
        char[] tChar = tar.toCharArray();
        int[] cnts = new int[256]; // 欠债表
        // 遍历更新"欠债"
        for (char ch : tChar) {
            cnts[ch]--;
        }
        int len = Integer.MAX_VALUE;
        int start = 0;
        // l 是左边界 r 是右边界
        for (int l = 0, r = 0, debt = tChar.length; r < sChar.length; r++) {
            // 还款 更新债务(记账 or 还账)!!!
            if (cnts[sChar[r]]++ < 0) { // 这里一定会记账/还账 用于移动 l
                debt--;
            }
            // 此时 满足tar 但有可能不是最短的 尝试缩短左边界
            if (debt == 0) {
                while (cnts[sChar[l]] > 0) { // 开始进入: r又拿到了一个 l 指向的字母 l左移
                    cnts[sChar[l]]--;
                    l++;
                }
                // 记录长度 和 起始点 用于截取字符串
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);
    }
}
