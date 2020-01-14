package demo;

/**
 * Created by omottec on 21/02/2017.
 */
public class IntegerTest {
    public static void main(String[] args) {
        // java.lang.Integer.IntegerCache
        // java.lang.Integer.valueOf(int)
        Integer a = 100;
        Integer a1 = 100;

        Integer b = 1000;
        Integer b1 = 1000;

        Integer c = new Integer(100);
        Integer c1 = new Integer(100);

        Integer d = new Integer(1000);
        Integer d1 = new Integer(1000);

        System.out.println(a == a1);
        System.out.println(b == b1);
        System.out.println(c == c1);
        System.out.println(d == d1);
    }
}
