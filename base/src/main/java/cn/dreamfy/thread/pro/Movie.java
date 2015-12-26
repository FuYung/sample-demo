package cn.dreamfy.thread.pro;

/**
 * 共同的资源 生产者消费者模式，信号灯法
 */
public class Movie {

    private String pic;
    // flag --> F 生产者生产，消费者等待
    // flag --> T 消费者消费，生产者等待
    private boolean flag = false;


    public synchronized void play(String pic) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产者生产，消费者等待");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic = pic;
        System.out.println("生产者生产了:" + pic);
        System.out.println("生产者生产完毕，通知消费者消费");
        this.notifyAll();
        this.flag = true;
    }

    public synchronized void watch() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费，生产者等待");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者消费了：" + pic);
        System.out.println("消费者消费完毕，通知生产者生产");
        this.notify();
        this.flag = false;
    }
}
