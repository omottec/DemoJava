package equals;

/**
 * Created by qinbingbing on 4/28/16.
 */
public class EqualTest {
    public static void main(String[] args) {
        String a = null;
        String b = null;
        String c = "abcsdfjlfjslfjdl";
        String d = "abcsdfjlfjslfjdl";
        System.out.println("a == b: " + (a == b));
        System.out.println("c == d: " + (c == d));
        System.out.printf("c.equals(a): " + c.equals(a));
        System.out.println("a.equals(c): " + a.equals(c));
    }
}
