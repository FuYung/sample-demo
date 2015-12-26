package cn.dreamfy.thread;

/**
 * 线程的互斥（锁定的是同一个对象）
 */
public class ThreadSynchronized {

    public static void main(String[] args) {

        new ThreadSynchronized().init();
    }

    private void init() {
        final Outputer outputer = new Outputer();// 内部类访问局部成员变量需加final
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("baidu baidu baidu");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    outputer.output("google google google");
                    Outputer.output3("google google google");
                }
            }
        }).start();
    }

    static class Outputer {
        public void output(String name) {
            synchronized (this) {
                int len = name.length();
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public synchronized void output2(String name) {
            System.out.println(this);
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public static synchronized void output3(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
