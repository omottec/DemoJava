package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 6/29/16.
 */
public class InstanceVolatileTest {
    public static final int THREAD_NUM = 1000;
    private volatile int count;
    private CountDownLatch latch = new CountDownLatch(THREAD_NUM);

    private void inc() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        latch.countDown();
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        final InstanceVolatileTest test = new InstanceVolatileTest();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread() {
                @Override
                public void run() {
                    test.inc();
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
