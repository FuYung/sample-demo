package cn.dreamfy.thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadWriterLockTest {

    public static void main(String[] args) {
        final Queue3 queue = new Queue3();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.getData();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.putDate(new Random().nextInt(1000));
                }
            }).start();
        }
    }


}

class Queue3 {
    private Object data = null;// 共享数据，同时只能有一个线程写入，同时可以有多个线程读取

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void getData() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "be ready to read data!");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "have read data " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void putDate(Object data) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "be ready to write data!");
            Thread.sleep(1000);
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "have write data " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
