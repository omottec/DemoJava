package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by qinbingbing on 05/03/2019.
 */
public class ThreadTest {
    private static boolean wait = true;
    private static int count = 0;

    public static void main(String[] args) {
//        testSleep();
        testWait();
    }

    private static void testSleep() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread.State state = getState();
                System.out.println("state when run: " + state);
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread.State state = thread.getState();
        System.out.println("state before run: " + state);
        thread.start();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Thread.State state1 = thread.getState();
                System.out.println("timer check state: " + state1);
                if (state1 == Thread.State.TERMINATED)
                    timer.cancel();
            }
        }, 0, 1000);
    }

    private static void testWait() {
        Object obj = new Object();

        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread.State state = getState();
                System.out.println("state when run: " + state);
                try {
                    synchronized (obj) {
                        synchronized (this) {
                            while (wait) {
                                System.out.println("in sync block");
                                System.out.println("Thread.holdsLock(this):" + Thread.holdsLock(this));
                                System.out.println("Thread.holdsLock(obj):" + Thread.holdsLock(obj));
                                System.out.println("wait-------------");
                                wait(3000);
                                state = getState();
                                System.out.println("state after wait: " + state);
                                System.out.println("Thread.holdsLock(this):" + Thread.holdsLock(this));
                                System.out.println("Thread.holdsLock(obj):" + Thread.holdsLock(obj));
                            }
                        }
                    }
                    System.out.println("out sync block");
                    System.out.println("Thread.holdsLock(this):" + Thread.holdsLock(this));
                    System.out.println("Thread.holdsLock(obj):" + Thread.holdsLock(obj));
                    state = getState();
                    System.out.println("state when out sync block: " + state);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread.State state = thread.getState();
        System.out.println("state before start: " + state);
        System.out.println("start-------------");
        thread.start();
        System.out.println("state after start: " + state);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Thread.State state1 = thread.getState();
                System.out.println("timer check state: " + state1);
                if (state1 == Thread.State.TERMINATED)
                    timer.cancel();
                if (state1 == Thread.State.TIMED_WAITING) {
                    count++;
                    if (count == 3) {
                        synchronized (obj) {
                            synchronized (thread) {
                                System.out.println("notify-------------");
                                wait = false;
                                thread.notify();
                                try {
                                    Thread.currentThread().sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }, 0, 1000);
    }
}
