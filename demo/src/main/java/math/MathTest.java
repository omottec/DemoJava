package math;

import java.math.BigDecimal;

/**
 * Created by qinbingbing on 09/06/2017.
 */
public class MathTest {
    public static void main(String[] args) {
        testTrimmedValue();
    }

    private static void testTrimmedValue() {
        System.out.println(MathUtils.getTrimmedValue(.0));
        System.out.println(MathUtils.getTrimmedValue(0.00));
        System.out.println(MathUtils.getTrimmedValue(1.00));
        System.out.println(MathUtils.getTrimmedValue(1.20));
        System.out.println(MathUtils.getTrimmedValue(1.0));
        System.out.println(MathUtils.getTrimmedValue(1.));
        System.out.println(MathUtils.getTrimmedValue(29d - 136.7 ));
        System.out.println(MathUtils.getTrimmedValue(BigDecimal.valueOf(29).subtract(BigDecimal.valueOf(136.70)).doubleValue()));
        System.out.println(MathUtils.getTrimmedValue(BigDecimal.valueOf(42).subtract(BigDecimal.valueOf(20)).doubleValue()));
        System.out.println(BigDecimal.valueOf(40).subtract(BigDecimal.valueOf(20)).floatValue());
        System.out.println(BigDecimal.valueOf(40).subtract(BigDecimal.valueOf(20)).toString());
    }
}
