package concurrent.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by qinbingbing on 15/12/2017.
 */
public class Manager1 {
    private List<Listener> mListeners = new ArrayList<>();

    private Manager1() {}

    private static class SingletonHolder {
        private static final Manager1 SINGLETON = new Manager1();
    }

    public static Manager1 getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public synchronized void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    public synchronized void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    public void notifyUpdate() {
        System.out.println("Manager1 notifyUpdate");
        List<Listener> list = new ArrayList();
        synchronized (this) {
            list.addAll(mListeners);
        }
        for (Listener listener : list) listener.update();
    }
}
