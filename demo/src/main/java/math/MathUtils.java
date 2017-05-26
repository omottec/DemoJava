package math;

/**
 * Created by qinbingbing on 26/05/2017.
 */
public final class MathUtils {
    private MathUtils() { throw new AssertionError(); }

    public static String getTrimmedValue(double d) {
        String s = String.valueOf(d);
        while (!"".equals(s) && (s.charAt(s.length() - 1) == '0' || s.charAt(s.length() - 1) == '.'))
            s = s.substring(0, s.length() - 1);
        if ("".equals(s)) return String.valueOf("0");
        return s;
    }
}
