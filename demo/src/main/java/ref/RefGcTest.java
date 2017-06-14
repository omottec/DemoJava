package ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 4/5/16.
 */
public class RefGcTest {
    public static void main(String[] args) {
        ReferenceQueue<ReferentObject> refQueue = new ReferenceQueue<>();
        WeakReference<ReferentObject> weakRef = new WeakReference<>(new ReferentObject(), refQueue);
        SoftReference<ReferentObject> softRef = new SoftReference<>(new ReferentObject(), refQueue);
        ReferentObject strongRef = new ReferentObject();
        System.out.println("weakRef: " + weakRef + ", weakRef.get: " + weakRef.get());
        System.out.println("softRef: " + softRef + ", softRef.get: " + softRef.get());
        System.out.println("strongRef: " + strongRef);
        Reference<? extends ReferentObject> polledRef;
        try {
            for (int i = 0; i < 5; i++) {
                System.gc();
                TimeUnit.MILLISECONDS.sleep(100);
                while ((polledRef = refQueue.poll()) != null) {
                    System.out.println("gc: " + i);
                    System.out.println("polledRef: " + polledRef + ", polledRef.get:" + polledRef.get());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        MemorySimulator.asyncDrainMemory();
//        MemorySimulator.drainMemory();
    }
}
