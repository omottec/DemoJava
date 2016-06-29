package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 6/29/16.
 */
public class VolatileIntTest {
    public static final int THREAD_NUM = 10;
    private volatile int count;
    private CountDownLatch latch = new CountDownLatch(THREAD_NUM);

    private void inc() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        final VolatileIntTest test = new VolatileIntTest();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++)
                        test.inc();
                    test.latch.countDown();
                }
            }.start();
        }
        try {
            test.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:" + test.count);
    }
}
