package 设计模式.单例模式;

/**
 * @description: 单例模式
 * @author: zhqihang
 * @date: 2024/07/28
 */

// 线程不安全版本 懒汉模式
public class Singleton_unsafe {

    private static Singleton_unsafe singleton = null;

    private Singleton_unsafe() {
    }

    // 通过该方法获取对象
    public static Singleton_unsafe getSingleton() {
        if (singleton == null) singleton = new Singleton_unsafe();
        return singleton;
    }

    // 也可以通过新增 同步 关键字 实现线程安全
    // public static synchronized Singleton_unsafe getSingleton() {}

}
