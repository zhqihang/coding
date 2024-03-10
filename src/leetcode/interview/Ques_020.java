package leetcode.interview;

import java.util.*;

/**
 * @Author: zhqihang
 * @Date: 2024/01/16
 * @Project: coding
 * @Description: 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 */
public class Ques_020 {

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) return false;

        // 匿名内部类
        // HashMap<Character, Character> pairs = new HashMap<>() {{
        //     put(')', '(');
        //     put(']', '[');
        //     put('}', '{');
        // }};

        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch))
                    return false;
                stack.pop();
            } else stack.push(ch);

        }
        return stack.isEmpty();
    }

    // 括号匹配 栈
    public boolean isValid1(String s) {
        // Stack<Character> stack = new Stack<>();
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        // 遍历 入栈
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 入栈时进行判断 是否匹配
            char c1 = '(';
            char c2 = '[';
            char c3 = '{';
            // 左括号入栈
            if (c == c1 || c == c2 || c == c3) {
                stack.push(c);
            } else {
                // 右括号单身
                if (stack.isEmpty()) {
                    return false;
                }
                // 左右匹配
                Character pop = stack.pop();
                if ((c == ')' && pop != c1)) return false;
                if ((c == ']' && pop != c2)) return false;
                if ((c == '}' && pop != c3)) return false;
            }
        }
        return stack.isEmpty();
    }
}
