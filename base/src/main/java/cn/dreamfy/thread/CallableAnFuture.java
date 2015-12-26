package cn.dreamfy.thread;

import java.util.concurrent.*;

/**
 */
public class CallableAnFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "hello";
            }
        });

        System.out.println("等待结果！");
        System.out.println("结果为：" + future.get());

        threadPool.shutdown();
    }
}
