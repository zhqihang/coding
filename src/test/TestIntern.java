package test;

/**
 * @author: qihang
 * @CreateDate: 2023/12/18/ 11:03
 * @Project: coding
 * @Description: ......
 */
public class TestIntern {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = "Hello";

        // 使用 intern() 方法将字符串添加到常量池
        String str3 = str1.intern();

        System.out.println(str1 == str2); // 输出 false，因为str1和str2引用不同的对象
        System.out.println(str2 == str3); // 输出 true，因为str3引用的是常量池中的字符串
    }
}
