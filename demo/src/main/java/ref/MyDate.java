package ref;

import java.util.Date;

/**
 * Created by qinbingbing on 4/5/16.
 */
public class MyDate extends Date {
    public MyDate() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this + " is gc");
    }

    @Override
    public String toString() {
        return "MyDate[Time: " + this.getTime() + "]";
    }
}
