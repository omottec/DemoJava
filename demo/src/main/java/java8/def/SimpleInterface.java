package java8.def;

/**
 * Created by qinbingbing on 12/21/16.
 */
public interface SimpleInterface extends PlainInterface {
    void doSomeWork();

    @Override
    default void defaultMethod() {
        System.out.println("defaultMethod in SimpleInterface");
    }

    static void staticMethod() {
        System.out.println("staticMethod in SimpleInterface");
    }
}
