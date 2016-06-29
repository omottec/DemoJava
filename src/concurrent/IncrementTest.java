package concurrent;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qinbingbing on 6/29/16.
 */
public class IncrementTest {
    public static final int THREAD_NUM = 10;

    private int count;

    private AtomicInteger atomicCount = new AtomicInteger();

    private int exeCount;

    private volatile int volatileCount;

    private Lock lock = new ReentrantLock();

    private Lock exeLock = new ReentrantLock();

    private CountDownLatch latch = new CountDownLatch(THREAD_NUM);

    private synchronized void synchronizedInc() {
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    private void lockInc() {
        lock.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(5);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void atomicInc() {
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicCount.getAndIncrement();
    }

    private void volatileInc() {
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileCount++;
    }

    public static void main(String[] args) {
        final IncrementTest test = new IncrementTest();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
//                        test.volatileInc();
//                        test.atomicInc();
//                        test.synchronizedInc();
                        test.lockInc();
                        test.exeLock.lock();
                        try {
                            System.out.println("exeCount:" + test.exeCount++);
                        } finally {
                            test.exeLock.unlock();
                        }
                    }
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
        System.out.println("atomicCount:" + test.atomicCount);
        System.out.println("volatileCount:" + test.volatileCount);
    }
}
