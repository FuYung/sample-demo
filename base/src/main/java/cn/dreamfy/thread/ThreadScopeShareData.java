package cn.dreamfy.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内共享变量
 */
public class ThreadScopeShareData {

//    private static int data;

    private static Map<Thread, Integer> threadData = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " put data: " + data);
                    threadData.put(Thread.currentThread(), data);
                    a();
                    b();
                }
            }).start();
        }
    }

    public static void a() {
        int data = threadData.get(Thread.currentThread());
        System.out.println("a from " + Thread.currentThread().getName() + " " +
                "get data " + data);
    }

    public static void b() {
        int data = threadData.get(Thread.currentThread());
        System.out.println("b from " + Thread.currentThread().getName() + " " +
                "get data " + data);
    }
}
