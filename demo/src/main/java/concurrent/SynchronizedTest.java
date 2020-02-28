package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by omottec on 28/02/2020.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Service service = new Service();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        new NamedThread("ThreadA", service, countDownLatch).start();
        new NamedThread("ThreadB", service, countDownLatch).start();
        new NamedThread("ThreadC", service, countDownLatch).start();
        new NamedThread("ThreadD", service, countDownLatch).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Service {
        public static synchronized void methodA() {
            System.out.println("methodA start execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
                System.out.println("methodA Thread.holdsLock(Service.class):" + Thread.holdsLock(Service.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("methodA end execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
        }

        public static synchronized void methodB() {
            System.out.println("methodB start execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
                System.out.println("methodB Thread.holdsLock(Service.class):" + Thread.holdsLock(Service.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("methodB end execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
        }

        public synchronized void methodC() {
            System.out.println("methodC start execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
                System.out.println("methodC Thread.holdsLock(Service.this): " + Thread.holdsLock(Service.this));
                System.out.println("methodC Thread.holdsLock(Service.class):" + Thread.holdsLock(Service.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("methodC end execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
        }

        public synchronized void methodD() {
            System.out.println("methodD start execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
                System.out.println("methodD Thread.holdsLock(Service.this): " + Thread.holdsLock(Service.this));
                System.out.println("methodD Thread.holdsLock(Service.class):" + Thread.holdsLock(Service.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("methodD end execute by " + Thread.currentThread() + " at " + System.currentTimeMillis());
        }
    }

    public static class NamedThread extends Thread {
        private Service service;
        private CountDownLatch countDownLatch;

        public NamedThread(String name, Service service, CountDownLatch countDownLatch) {
            super(name);
            this.service = service;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();
            switch (getName()) {
                case "ThreadA":
                    Service.methodA();
                    break;
                case "ThreadB":
                    Service.methodB();
                    break;
                case "ThreadC":
                    service.methodC();
                    break;
                case "ThreadD":
                    service.methodD();
                    break;
                default:
                    break;
            }
            countDownLatch.countDown();
        }
    }
}
