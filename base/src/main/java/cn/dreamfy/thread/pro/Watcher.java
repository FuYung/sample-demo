package cn.dreamfy.thread.pro;

/**
 * 消费者
 */
public class Watcher implements Runnable {
    private Movie m;

    public Watcher(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            m.watch();
        }
    }
}
