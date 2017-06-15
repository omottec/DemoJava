package ref;

import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * Created by qinbingbing on 4/5/16.
 */
public final class MemorySimulator {
    private MemorySimulator() {
    }

    public static void asyncDrainMemory() {
        for (int i = 0; i < 10; i++) {
            Executors.newSingleThreadExecutor().submit(new Runnable() {
                @Override
                public void run() {
                    drainMemory();
                }
            });
        }
    }
    
    public static void drainMemory() {
        byte[] bytes = new byte[1 * 1024 * 1024];
        System.out.println("alloc memory " + bytes.length / 1024 / 1024 + "M");
        for (int i = 0; i <= bytes.length; i++) {
            if (i == bytes.length) {
                bytes = Arrays.copyOf(bytes, bytes.length * 2);
                System.out.println("alloc memory " + bytes.length / 1024 / 1024 + "M");
            }
            bytes[i] = 1;
        }
    }
}
