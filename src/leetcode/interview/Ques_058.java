package leetcode.interview;

/**
 * @author: qihang
 * @CreateDate: 2023/12/22/ 16:03
 * @Project: coding
 * @Description: ......
 */
public class Ques_058 {

    public static void main(String[] args) {

    }


    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        // 处理末尾空格
        while (s.charAt(index) == ' ') {
            index--;
        }

        //
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
