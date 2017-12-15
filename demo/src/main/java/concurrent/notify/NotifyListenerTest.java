package concurrent.notify;

/**
 * Created by qinbingbing on 15/12/2017.
 */
public class NotifyListenerTest {

    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        Listener l = new Listener() {
            @Override
            public void update() {
                System.out.println("l update");
                manager.unregisterListener(this);
            }
        };
        Listener l1 = new Listener() {
            @Override
            public void update() {
                System.out.println("l1 update");
            }
        };
        Listener l2 = new Listener() {
            @Override
            public void update() {
                System.out.println("l2 update");
            }
        };
        manager.registerListener(l);
        manager.registerListener(l1);
        manager.registerListener(l2);
        manager.notifyUpdate();
        System.out.println("---------------------------");
        manager.notifyUpdate();
    }
}
