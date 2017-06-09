package decimal;

import junit.framework.TestCase;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * Created by qinbingbing on 09/06/2017.
 */
public class DecimalTest extends TestCase {
    @Test
    public void testDecimalFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        System.out.println(decimalFormat.format(.0));
        System.out.println(decimalFormat.format(.10));
        System.out.println(decimalFormat.format(.1));
        System.out.println(decimalFormat.format(1.00));
        System.out.println(decimalFormat.format(1.10));
        System.out.println(decimalFormat.format(1.0));
        System.out.println(decimalFormat.format(1.1));
        System.out.println(decimalFormat.format(1.0));
        System.out.println(decimalFormat.format(1.));
        System.out.println(decimalFormat.format(1.23));
    }
}
