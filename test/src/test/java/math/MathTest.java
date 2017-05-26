package math;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by qinbingbing on 26/05/2017.
 */
public class MathTest extends TestCase {
    @Test
    public void testFloatBit() {
        System.out.println(getTrimmedValue(123.45));
        System.out.println(getTrimmedValue(123.40));
        System.out.println(getTrimmedValue(123.00));
        System.out.println(getTrimmedValue(123.4));
        System.out.println(getTrimmedValue(123.0));
        System.out.println(getTrimmedValue(123.));
        System.out.println(getTrimmedValue(123));
        System.out.println("--------------");
        System.out.println(getTrimmedValue(0.12));
        System.out.println(getTrimmedValue(0.10));
        System.out.println(getTrimmedValue(0.00));
        System.out.println(getTrimmedValue(0.1));
        System.out.println(getTrimmedValue(0.0));
        System.out.println(getTrimmedValue(0.));
        System.out.println(getTrimmedValue(0));
    }



    private String getTrimmedValue(double d) {
        String s = String.valueOf(d);
        while (!"".equals(s) && (s.charAt(s.length() - 1) == '0' || s.charAt(s.length() - 1) == '.'))
            s = s.substring(0, s.length() - 1);
        if ("".equals(s)) return String.valueOf("0");
        return s;
    }

}
