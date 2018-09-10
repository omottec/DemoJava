package popup;

/**
 * Created by qinbingbing on 21/08/2018.
 */
public interface PopupTask extends Comparable<PopupTask> {
    int PRIORITY_0 = 0;
    int PRIORITY_1 = 1;
    int PRIORITY_2 = 2;
    int PRIORITY_3 = 3;

    int getIdentity();

    int getPriority();

    void popup();

    void onDismiss();
}
