package syntax;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by qinbingbing on 02/06/2017.
 */
public class NullTest extends TestCase {
    @Test
    public void testNull() {
        String str = (String)null;
        System.out.println("aaa" + str);
    }
}
