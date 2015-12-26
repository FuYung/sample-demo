package cn.dreamfy.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        ExecutorService threadPool = Executors.newCachedThreadPool();// 动态扩展线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单线程（实现线程死掉之后重新启动）
        for (int i = 1; i <= 10; i++) {

            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 10; j++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " is loop" + j + ", for task " + task);
                    }
                }
            });
        }
        threadPool.shutdown();

        // 创建一个定时任务
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        }, 10, TimeUnit.SECONDS);

        // 定时任务
        ScheduledExecutorService scheduledThreadPool2 = Executors.newScheduledThreadPool(3);
        scheduledThreadPool2.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        }, 2, 2, TimeUnit.SECONDS);

    }

}
