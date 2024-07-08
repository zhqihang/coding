package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: qihang
 * @CreateDate: 2023/12/11/ 17:02
 * @Project: coding
 * @Description: ......
 */
public class TestVolatile {
    public static void main(String[] args) {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void tenDown() throws InterruptedException {

        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间
        while (true) {
            try {
                Thread.sleep(1000);
                clearLine();
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());//更新当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearLine() {
        System.out.print("\r"); // 移动光标到行首
    }

}