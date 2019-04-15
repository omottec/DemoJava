package cpu;

import java.util.concurrent.TimeUnit;

/**
 * Created by omottec on 15/04/2019.
 */
public class NamedRunnable implements Runnable {
    private static int taskCount;
    private final int id = taskCount++;
    private int tick;

    @Override
    public void run() {
        while (true) {
            System.out.println(toString());
            tick++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "taskId:" + id
                + ", tick:" + tick
                + ", threadId:" + Thread.currentThread().getId()
                + ", threadName:" + Thread.currentThread().getName();
    }
}
