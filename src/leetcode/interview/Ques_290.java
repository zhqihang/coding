package leetcode.interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: zhqihang
 * @Date: 2024/01/12
 * @Project: coding
 * @Description: 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class Ques_290 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串！");
        String s = scanner.nextLine();
        // 130
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        System.out.println("wordPattern(pattern, s) = " + wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        // 字符串 单词数组
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<Object, Integer> map = new HashMap<>();
        // 这里要使用 Integer定义 i
        // 因为 map中的 value是 Integer的
        // 当大于128的时候 如果使用 int进行put操作, i-->Integer的自动装箱会 new新的对象
        // 此时, put的返回值 直接用==比较 就会报错
        // 所以直接 Integer定义i put直接存Integer 不牵扯自动装箱的问题
        // 涉及包装类型 Integer 缓存了 -127~128的问题
        for (Integer i = 0; i < words.length; i++) {
            /*
            put方法是有返回值的！
            如果key不存在，插入并返回null 如果key存在，返回存在key的value
             */
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean wordPattern1(String pattern, String s) {
        HashMap<String, Character> str2ch = new HashMap<>(); // 字符串到字符
        HashMap<Character, String> ch2str = new HashMap<>(); // 字符到字符串
        int m = s.length(); // 字符串长度
        int i = 0;
        // 遍历模式
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && s.charAt(j) != ' ') {
                j++;
            }
            String tmp = s.substring(i, j);
            // 如果这个字符串有对应的字符了 检查哈希表中的字符和当前的ch 如果不相等 返回false
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            // 如果这个字符有对应的字符串了  检查哈希表中的字符串和当前tmp 如果不相等 返回false
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1; // 更新i +1是跳过单词之间的空格
        }
        return i >= m; // 如果i小于m 说明模式已经遍历完 但是字符串还没有遍历完
    }
}
