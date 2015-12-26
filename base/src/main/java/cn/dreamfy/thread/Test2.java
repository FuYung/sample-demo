package cn.dreamfy.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(Test());
    }

    private static String Test() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        for(int i = 0; i< 10 ;i ++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName:" + Thread.currentThread().getName() + " print i = " + task);
                }
            });
            if (i == 9) {
                threadPool.shutdown();
            }
        }
        return "main thread shutdown";
    }

}
