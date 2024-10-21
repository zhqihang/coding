package 练习代码.线程创建;

/**
 * @description: 继承 Thread 并重写 run 方法
 * @author: zhqihang
 * @date: 2024/10/13
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("我是继承 Thread 类进行创建的");
    }

    public static void main(String[] args) {
        ThreadTest myThread = new ThreadTest();
        myThread.start(); // 启动线程
    }
}
