package java8;

/**
 * Created by qinbingbing on 12/21/16.
 */
public class SimpleInterfaceImpl implements SimpleInterface {

    @Override
    public void doSomeWork() {
        System.out.println("doSomeWork in SimpleInterfaceImpl");
    }

    @Override
    public void doSomeOtherWork() {
        System.out.println("doSomeOtherWork in SimpleInterfaceImpl");
    }

    public static void main(String[] args) {
        SimpleInterface si = new SimpleInterfaceImpl();
        si.doSomeWork();
        si.doSomeOtherWork();
    }
}
