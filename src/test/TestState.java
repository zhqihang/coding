package test;

/**
 * @author: qihang
 * @CreateDate: 2023/12/12/ 10:53
 * @Project: coding
 * @Description: ......
 */
public class TestState {
    public static void main(String[] args) throws InterruptedException{
        //线程体（lamda表达式）
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        //观察启动后的状态
        thread.start();
        state = thread.getState();
        System.out.println(state);//Run

        //只要线程不终止就一直输出状态
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();//更新线程状态
            System.out.println(state);
        }
    }
}