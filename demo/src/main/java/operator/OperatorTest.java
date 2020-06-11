package operator;

/**
 * Created by qinbingbing on 9/26/16.
 */
public class OperatorTest {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ false);
        System.out.println(false ^ true);
    }

    private static void test2() {
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = false;
        System.out.println(b1 || b2 && b3);
        System.out.println((b1 || b2) && b3);
        System.out.println(b1 || (b2 && b3));
    }
}
