package cn.dreamfy.thread;

/**
 * 多线程死锁经典案例
 * Created by vicfu on 2016/5/6.
 */
public class DeadLock {

	/* * This method request two locks, first String and then Integer */
	public static void method1() {
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName() + " Aquired lock on String.class object, by method1");
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + " Aquired lock on Integer.class object , by method1");
			}
		}
	}

	/* * This method also requests same two lock but in exactly * Opposite order i.e. first Integer and then String. * This creates potential deadlock, if one thread holds String lock * and other holds Integer lock and they wait for each other, forever. */
	public static void method2() {
		synchronized (Integer.class) {
			System.out.println(Thread.currentThread().getName() + " Aquired lock on Integer.class object, by method2");
			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName() + " Aquired lock on String.class object, by method2");
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					method1();
					method2();
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					method1();
					method2();
				}
			}).start();
		}
	}
}
