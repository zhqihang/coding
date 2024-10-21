package 练习代码.线程暂停方法;

/**
 * @description: sleep方法测试
 * @author: zhqihang
 * @date: 2024/10/21
 */
public class SleepDoesNoReleaseLock{

    private static final Object lock = new Object(); // 对象资源

    public static void main(String[] args) throws InterruptedException{
        // 创建线程1
        Thread sleepingThread = new Thread(() -> {
            // 加锁
            synchronized (lock) {
                System.out.println("线程1会继续持有锁，并进入睡眠状态");

                // 调用sleep方法
                try {
                    Thread.sleep(5000);
                    // lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1醒来了，并且释放了锁");
            }
        });

        // 创建线程2
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 进入同步代码块");
            }
            System.out.println("Thread2 释放了");
        });

        sleepingThread.start(); // 启动线程1
        Thread.sleep(1000);
        waitingThread.start(); // 启动线程2
    }

}
