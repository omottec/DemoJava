package api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by qinbingbing on 08/06/2017.
 */
public class ApiTest extends TestCase {
    @Test
    public void testAssertNull() {
        Assert.assertNull((String) null);
        Assert.assertNull((Void) null);
        Assert.assertNull((Object) null);
    }
}
