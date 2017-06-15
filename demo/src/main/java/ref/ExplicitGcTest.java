package ref;

import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 4/5/16.
 */
public class ExplicitGcTest {
    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
        System.gc();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
