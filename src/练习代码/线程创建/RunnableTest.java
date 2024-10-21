package 练习代码.线程创建;

/**
 * @description: 实现 Runnable 接口
 * @author: zhqihang
 * @date: 2024/10/13
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("我是实现 Runnable 接口进行创建的");
    }

    public static void main(String[] args) {
        /*
        JVM 执行start方法会先创建一条线程，由这条新线程去执行 run 方法
         */
        RunnableTest task = new RunnableTest();
        new Thread(task).start(); // 启动线程
    }
}
