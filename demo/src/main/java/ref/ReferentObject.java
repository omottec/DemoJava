package ref;

/**
 * Created by qinbingbing on 14/06/2017.
 */
public class ReferentObject {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize " + this);;
    }
}
