package cn.dreamfy.thread;

/**
 * 线程的创建方式
 */
public class Test1 {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadName1:" + Thread.currentThread()
                            .getName());
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadName2:" + Thread.currentThread()
                            .getName());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("thread");
            }
        }.start();
    }
}
