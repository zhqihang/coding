package 练习代码.线程创建;

import java.util.concurrent.*;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/10/13
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "我是实现 Callable 接口进行创建的";
    }

    public static void main(String[] args) {
        // 创建异步任务
        FutureTask<String> task = new FutureTask<>(new CallableTest());
        // 启动线程
        new Thread(task).start();
        try {
            // 等待线程执行完毕，并获取返回结果
            String res = task.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
