package concurrent.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by qinbingbing on 15/12/2017.
 */
public class Manager {
    private List<Listener> mListeners = new CopyOnWriteArrayList<>();

    private Manager() {}

    private static class SingletonHolder {
        private static final Manager SINGLETON = new Manager();
    }

    public static Manager getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    public void notifyUpdate() {
        System.out.println("Manager notifyUpdate");
        for (Listener listener : mListeners) listener.update();
    }
}
