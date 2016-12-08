package concurrent;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qinbingbing on 12/8/16.
 */
public class ThreadLocalImulation {
    private static final AtomicInteger NEXT_ID = new AtomicInteger(0);
    private static final ConcurrentHashMap<Long, Integer> ID_MAP = new ConcurrentHashMap<>();
    public static final Random RANDOM = new Random();

    public static int fetchId() {
        Integer id = ID_MAP.get(Thread.currentThread().getId());
        if (id == null) id = NEXT_ID.getAndIncrement();
        ID_MAP.put(Thread.currentThread().getId(), id);
        return id;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new TestThread().start();
    }

    private static class TestThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("name:" + getName()
                        + ", sysId:" + getId()
                        + ", id:" + fetchId());
                try {
                    TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(300));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
