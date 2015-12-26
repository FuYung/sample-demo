package cn.dreamfy.thread;

import java.util.Random;

public class ThreadLocalTest {


    public static void main(String[] args) {

        for (int i = 1; i <= 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int random = new Random().nextInt();

                    System.out.println(Thread.currentThread().getName() + " " +
                            "put " +
                            "data " + random);
                    MyThreadData.getThreadInstance().setName(Thread.currentThread()
                            .getName() + "random");
                    MyThreadData.getThreadInstance().setAge(random);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName()
                    + " name " + MyThreadData.getThreadInstance().getName() + " age" +
                    " " + MyThreadData.getThreadInstance().getAge());
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName()
                    + " name " + MyThreadData.getThreadInstance().getName() + " age" +
                    " " + MyThreadData.getThreadInstance().getAge());
        }
    }

    static class MyThreadData {
        private MyThreadData() {
        }

        private static ThreadLocal<MyThreadData> threadMapData = new
                ThreadLocal<>();

        /**
         * 保证在一个线程内只有一个实例
         */
        public static MyThreadData getThreadInstance() {
            MyThreadData instance = threadMapData.get();
            if (instance == null) {
                instance = new MyThreadData();
                threadMapData.set(instance);
            }
            return instance;
        }

        private String name;
        private int age;


        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static void main(String[] args) {
            for (int i = 0; i < 3; i++) {
                final Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread() + " " + MyThreadData
                                .getThreadInstance());
                    }
                });
                thread.start();
            }
        }
    }
}
