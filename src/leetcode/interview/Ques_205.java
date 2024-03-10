package leetcode.interview;

import java.util.HashMap;

/**
 * @Author: zhqihang
 * @Date: 2024/01/12
 * @Project: coding
 * @Description: 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class Ques_205 {

    // 哈希表 双射  两个哈希表 进行遍历
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char x = s.charAt(i), y = t.charAt(i);
            // 是否出现冲突
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
