package java8.def;

/**
 * Created by qinbingbing on 12/21/16.
 */
public interface PlainInterface {
    default void defaultMethod() {
        System.out.println("defaultMethod in PlainInterface");
    }

    static void staticMethod() {
        System.out.println("staticMethod in PlainInterface");
    }
}
