package leetcode.interview;

/**
 * @Author: zhqihang
 * @Date: 2024/02/26
 * @Project: coding
 * @Description: 反转字符串中的单词
 * <p>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 */
public class Ques_151 {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    // 反转单词
    public void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 1;
        int len = sb.length();
        while (start < len) {
            // 取每个单词
            while (end < len && sb.charAt(end) != ' ') {
                end++;
            }
            // 反转
            reverseString(sb, start, end - 1);
            // 开始下个单词
            start = end + 1;
            end = start + 1;
        }
    }

    // 反转字符串
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    // 移除多余空格
    public StringBuilder removeSpace(String s) {
        int start = 0, end = s.length() - 1;
        // 移除前后空格
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 当前字符不为空格 加入
            // 当前字符为空格 但是上一位不是空格 加入 保证单词之间只有一个空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
}
