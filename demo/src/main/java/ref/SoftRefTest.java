package ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 4/5/16.
 */
public class SoftRefTest {
    public static void main(String[] args) {
//        SoftReference<MyDate> ref = new SoftReference<MyDate>(new MyDate());
        ReferenceQueue<MyDate> refQueue = new ReferenceQueue<MyDate>();
        SoftReference<MyDate> ref = new SoftReference<MyDate>(new MyDate(), refQueue);
        System.out.println("new ref: " + ref);
        Reference<? extends MyDate> polledRef;
        try {
            for (int i = 0; i < 5; i++) {
                System.gc();
                TimeUnit.MILLISECONDS.sleep(100);
                while ((polledRef = refQueue.poll()) != null) {
                    System.out.println("i: " + i);
                    System.out.println("queue poll ref: " + polledRef);
                    MyDate myDate = polledRef.get();
                    System.out.println("ref get: " + myDate);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        MemorySimulator.drainMemory();
        /*MemorySimulator.asyncDrainMemory();
        while (true) {
            polledRef = refQueue.poll();
            if (polledRef != null) {
                System.out.println("queue poll ref: " + polledRef);
                System.out.println("queue poll ref: " + polledRef);
                MyDate myDate = polledRef.get();
                System.out.println("ref get: " + myDate);
            }
        }*/
    }
}
