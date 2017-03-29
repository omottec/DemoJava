package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 6/29/16.
 */
public class VolatileBooleanTest {
    public static final int THREAD_NUM = 10;
    private volatile boolean b;
    private CountDownLatch latch = new CountDownLatch(THREAD_NUM);

    private void reverse(boolean signal) {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b = signal;
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        final VolatileBooleanTest test = new VolatileBooleanTest();
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
        System.out.println("b:" + test.b);
    }
}
