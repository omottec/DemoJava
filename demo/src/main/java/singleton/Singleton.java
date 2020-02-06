package singleton;

/**
 * Created by omottec on 06/02/2020.
 * static inner class
 */
public class Singleton {
    private Singleton() {}

    private static class InstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
