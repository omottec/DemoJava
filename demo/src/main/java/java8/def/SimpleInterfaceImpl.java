package java8.def;

/**
 * Created by qinbingbing on 12/21/16.
 */
public class SimpleInterfaceImpl implements SimpleInterface {

    @Override
    public void doSomeWork() {
        System.out.println("doSomeWork in SimpleInterfaceImpl");
    }

    @Override
    public void defaultMethod() {
        System.out.println("defaultMethod in SimpleInterfaceImpl");
    }

    public static void main(String[] args) {
        SimpleInterface si = new SimpleInterfaceImpl();
        si.doSomeWork();
        si.defaultMethod();
        SimpleInterface.staticMethod();
        PlainInterface.staticMethod();
    }
}
