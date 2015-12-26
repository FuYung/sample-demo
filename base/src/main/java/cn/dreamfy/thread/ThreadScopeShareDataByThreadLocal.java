package cn.dreamfy.thread;

import java.util.Random;

/**
 * 线程范围内共享变量(ThreadLocal)
 * ThreadLocal：相当于一个map
 */
public class ThreadScopeShareDataByThreadLocal {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " put data" + data);
                    threadLocal.set(data);
                    a();
                    b();
                }
            }).start();
        }
    }

    public static void a() {
        int data = threadLocal.get();
        System.out.println("a from " + Thread.currentThread().getName() + " " +
                "get data " + data);
    }

    public static void b() {
        int data = threadLocal.get();
        System.out.println("b from " + Thread.currentThread().getName() + " " +
                "get data " + data);
    }

}
