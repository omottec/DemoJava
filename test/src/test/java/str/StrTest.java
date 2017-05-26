package str;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by qinbingbing on 26/05/2017.
 */
public class StrTest extends TestCase {
    @Test
    public void testFormat() {
        System.out.println(String.format("%7.3f", 11.2222));
    }
}
