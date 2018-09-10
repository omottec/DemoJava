package popup;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by qinbingbing on 21/08/2018.
 */
public class PopupManager {
    private PopupManager() {}

    private static class PopupManagerHolder {
        private static final PopupManager INSTANCE = new PopupManager();
    }

    public PopupManager getInstance() {
        return PopupManagerHolder.INSTANCE;
    }

    private PriorityQueue<PopupTask> mTaskQueue = new PriorityQueue<>();

    public void add(PopupTask popupTask) {
        synchronized (mTaskQueue) {
            if (mTaskQueue.isEmpty()) {
                try {
                    popupTask.popup();
                } catch (Exception e) {
                    return;
                }
            }
            mTaskQueue.add(popupTask);
        }
    }

    public void remove(PopupTask popupTask) {
        synchronized (this) {
            mTaskQueue.remove(popupTask);
            PopupTask peekTask = mTaskQueue.peek();
            if (peekTask != null) {
                try {
                    peekTask.popup();
                } catch (Exception e) {
                    remove(peekTask);
                }
            }
        }
    }

    public void remove(int identity) {
        synchronized (this) {
            Iterator<PopupTask> iterator = mTaskQueue.iterator();
            PopupTask task;
            while (iterator.hasNext()) {
                task = iterator.next();
                if (task.getIdentity() == identity) {
                    iterator.remove();
                    break;
                }
            }
            PopupTask peekTask = mTaskQueue.peek();
            if (peekTask != null) {
                try {
                    peekTask.popup();
                } catch (Exception e) {
                    remove(peekTask.getIdentity());
                }
            }
        }
    }
}
