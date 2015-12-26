package cn.dreamfy.thread;

/**
 * 多个线程之间共享数据
 */
public class MultiThreadShareDate {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(shareData).start();
        new Thread(shareData).start();
    }


}

class ShareData implements Runnable{

    @Override
    public void run() {

    }
}