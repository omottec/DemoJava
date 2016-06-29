package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 6/29/16.
 */
public class StaticVolatileIntTest {
    public static final int THREAD_NUM = 1000;
    public static volatile int count = 0;
    private static CountDownLatch downLatch = new CountDownLatch(THREAD_NUM);

    public static void inc() {
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        downLatch.countDown();
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_NUM; i++)
            new Thread() {
                @Override
                public void run() {
                    inc();
                }
            }.start();
        downLatch.await();
        System.out.println("count:" + count);
    }
}
