package ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 4/5/16.
 */
public class PhantomRefTest {
    public static void main(String[] args) {
        ReferenceQueue<MyDate> refQueue = new ReferenceQueue<MyDate>();
        PhantomReference<MyDate> ref = new PhantomReference<MyDate>(new MyDate(), refQueue);
        System.out.println("new ref: " + ref);
        Reference<? extends MyDate> polledRef;
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.gc();
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

//        MemorySimulator.asyncDrainMemory();
    }
}
