package java8;

/**
 * Created by qinbingbing on 12/21/16.
 */
public interface SimpleInterface {
    void doSomeWork();

    default void doSomeOtherWork() {
        System.out.println("doSomeOtherWork in SimpleInterface");
    }
}
