package integer;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by qinbingbing on 29/03/2017.
 */
public class IntegerTest extends TestCase {

    @Test
    public void testInteger() {
        int bufferInt = 127;
        int unBufferInt = 120;
        Integer i = bufferInt;
        Integer i1 = bufferInt;
        Integer i2 = unBufferInt;
        Integer i3 = unBufferInt;
        assert i == i1;
        assert i2 == i3;
    }
}
