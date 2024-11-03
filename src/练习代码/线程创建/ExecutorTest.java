package 练习代码.线程创建;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 使用线程池创建线程
 * @author: zhqihang
 * @date: 2024/11/03
 */
public class ExecutorTest implements Runnable{


    @Override
    public void run() {
        // 线程执行的代码
        System.out.println("使用Executor框架创建线程池");
    }

    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            // 提交任务到线程池执行
            executor.submit(new ExecutorTest());
        }
        // 关闭线程池
        executor.shutdown();
    }
}
