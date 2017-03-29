package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by qinbingbing on 6/29/16.
 */
public class AtomicBooleanTest {
    public static final int THREAD_NUM = 10;
    private AtomicBoolean b = new AtomicBoolean(false);
    private CountDownLatch latch = new CountDownLatch(THREAD_NUM);

    private void reverse(boolean signal) {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.set(signal);
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        final AtomicBooleanTest test = new AtomicBooleanTest();
        for (int i = 0; i < THREAD_NUM; i++) {
            final int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.reverse((j % 2 == 0));
                    test.latch.countDown();
                }
            }.start();
        }
        try {
            test.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b:" + test.b.get());
    }
}
