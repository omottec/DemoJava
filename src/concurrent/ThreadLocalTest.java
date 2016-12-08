package concurrent;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qinbingbing on 12/8/16.
 */
public class ThreadLocalTest {
    public static final Random RANDOM = new Random();
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    private static class GetThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("name:" + getName()
                        + ", sysId:" + getId()
                        + ", id:" + get());
                try {
                    TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new GetThread().start();
    }
}
