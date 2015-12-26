package cn.dreamfy.thread;

/**
 * 线程同步的通信
 * 主线程循环10次，接着子线程循环100次，接着主线程又循环10次，子线程循环100次...如此循环50次
 */
public class ThreadCommunication {

    public static void main(String[] args) {
        new ThreadCommunication().init();
    }

    private void init() {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.main(i);
                    business.sub(i);
                }
            }
        }).start();
    }

    class Business {
        private boolean bShouldSub = false;

        public synchronized void sub(int i) {
            while (!bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 100; j++) {
                System.out.println("sub run " + j + " loop of " + i);
            }
            bShouldSub = false;
            this.notify();
        }

        public synchronized void main(int i) {

            while (bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("main run " + j + " loop of " + i);
            }
            bShouldSub = true;
            this.notify();
        }
    }
}
