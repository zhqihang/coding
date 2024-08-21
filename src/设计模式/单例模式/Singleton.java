package 设计模式.单例模式;

/**
 * @description: 单例模式
 * @author: zhqihang
 * @date: 2024/07/28
 */
public class Singleton {

    public Singleton() {}
    // 限制产生多个对象
    private static final Singleton singleton = new Singleton();

    // 获取实例对象方法
    public static Singleton getSingleton() {
        return singleton;
    }

    // 其他方法
    public static void doSomething() {
        // TODO
    }
}
