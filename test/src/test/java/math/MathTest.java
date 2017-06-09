package math;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by qinbingbing on 26/05/2017.
 */
public class MathTest extends TestCase {
    @Test
    public void testGetTrimmedValue() {
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

    @Test
    public void testGetTrimmedValue1() {
        System.out.println(getTrimmedValue1(123.45));
        System.out.println(getTrimmedValue1(123.40));
        System.out.println(getTrimmedValue1(123.00));
        System.out.println(getTrimmedValue1(123.4));
        System.out.println(getTrimmedValue1(123.0));
        System.out.println(getTrimmedValue1(123.));
        System.out.println(getTrimmedValue1(123));
        System.out.println("--------------");
        System.out.println(getTrimmedValue1(0.12));
        System.out.println(getTrimmedValue1(0.10));
        System.out.println(getTrimmedValue1(0.00));
        System.out.println(getTrimmedValue1(0.1));
        System.out.println(getTrimmedValue1(0.0));
        System.out.println(getTrimmedValue1(0.));
        System.out.println(getTrimmedValue1(0));
    }



    private String getTrimmedValue(double d) {
        String s = String.valueOf(d);
        if (!s.contains(".")) return s;
        while (s.charAt(s.length()-1) == '0')
            s = s.substring(0, s.length()-1);
        if (s.charAt(s.length()-1) == '.')
            return s.substring(0, s.length() - 1);
        if ("".equals(s)) return String.valueOf("0");
        return s;
    }

    private String getTrimmedValue1(double d) {
        String s = String.valueOf(d);
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");
            s = s.replaceAll("[.]$", "");
        }
        return s;
    }

    @Test
    public void testMinus() {
        System.out.println(125 - 123.00);
        BigDecimal bigDecimal = BigDecimal.valueOf(125).subtract(new BigDecimal("123.00"));
        System.out.println("bigDecimal" + bigDecimal);
        System.out.println("bigDecimal.doubleValue:" + bigDecimal.doubleValue());
        System.out.println("bigDecimal.stripTrailingZeros:" + bigDecimal.stripTrailingZeros());
        System.out.println("getTrimmedValue(bigDecimal.doubleValue()):" + getTrimmedValue(bigDecimal.doubleValue()));
    }

    @Test
    public void testTrimmedValue() {
        System.out.println(getTrimmedValue(.30));
        System.out.println(getTrimmedValue(.00));
        System.out.println(getTrimmedValue(0.1));
        System.out.println(getTrimmedValue(0.0));
        System.out.println(getTrimmedValue(.1));
        System.out.println(getTrimmedValue(.0));
    }

    @Test
    public void testStripTrailingZeros() {
        System.out.println(new BigDecimal(".30").stripTrailingZeros());
        System.out.println(new BigDecimal(".00").stripTrailingZeros());
        System.out.println(new BigDecimal("0.1").stripTrailingZeros());
        System.out.println(new BigDecimal("0.0").stripTrailingZeros());
        System.out.println(new BigDecimal(".1").stripTrailingZeros());
        System.out.println(new BigDecimal(".0").stripTrailingZeros());
        System.out.println(new BigDecimal(8.3).stripTrailingZeros());

        BigDecimal decimal = BigDecimal.valueOf(2000)
                .divide(BigDecimal.valueOf(100))
                .subtract(new BigDecimal("11.7"));
        System.out.println(String.format("差&#165;%s可送", decimal.stripTrailingZeros()));

    }

    @Test
    public void testDiv() {
        System.out.println((double) 34207 / 100);
        System.out.println((double) 34288 / 100);
        System.out.println(BigDecimal.valueOf(34288).divide(BigDecimal.valueOf(100)).doubleValue());
    }
}
