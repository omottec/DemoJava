package demo;

/**
 * Created by omottec on 21/02/2017.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 100;
        Integer i1 = 100;
        Integer i2 = 1000;
        Integer i3 = 1000;

        System.out.println(i == i1);
        System.out.println(i1 == i2);
        System.out.println(i2 == i3);
    }
}
