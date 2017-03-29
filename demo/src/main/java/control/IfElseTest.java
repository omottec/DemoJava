package control;

/**
 * Created by qinbingbing on 4/12/16.
 */
public class IfElseTest {
    public static void main(String[] args) {
        int a = 3;
        if (a > 5) {
            System.out.println("a > 5");
        } else if (a > 4) {
            System.out.println("a > 4");
        } else if (a > 3) {
            System.out.println("a > 3");
        } else if (a > 2) {
            System.out.println("a > 2");
        } else if (a > 1) {
            System.out.println("a > 1");
        } else if (a > 0) {
            System.out.println("a > 0");
        } else {
            System.out.println("a <= 0");
        }
    }
}
