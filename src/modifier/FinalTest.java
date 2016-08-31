package modifier;

/**
 * Created by qinbingbing on 8/31/16.
 */
public class FinalTest {
    private final int finalField = 5;

    private void testFinalVar() {
        final boolean b;
        b = true;
        System.out.println(b);
    }

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
//        finalTest.finalField = 3;
        final boolean b;
        b = true;
        System.out.println(b);
    }
}
