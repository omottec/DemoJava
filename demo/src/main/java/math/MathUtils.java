package math;

/**
 * Created by qinbingbing on 26/05/2017.
 */
public final class MathUtils {
    private MathUtils() { throw new AssertionError(); }

    public static String getTrimmedValue(double d) {
        String s = String.valueOf(d);
//        System.out.println("d:" + d + ", s:" + s);
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");
            s = s.replaceAll("[.]$", "");
        }
        if ("".equals(s)) return String.valueOf(0);
        return s;
    }

    private static String getTrimmedValue1(double d) {
        String s = String.valueOf(d);
        if (!s.contains(".")) return s;
        while (s.charAt(s.length()-1) == '0')
            s = s.substring(0, s.length()-1);
        if (s.charAt(s.length()-1) == '.')
            return s.substring(0, s.length() - 1);
        if ("".equals(s)) return String.valueOf("0");
        return s;
    }

}
