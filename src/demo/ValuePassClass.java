package demo;

/**
 * Created by omottec on 21/02/2017.
 */
public class ValuePassClass {
    private static void change(String a) {
        a = "bbb";
    }

    private static void change(int b) {
        b = 2;
    }

    public static void main(String[] args) {
        String a = "aaa";
        change(a);
        System.out.println(a);

        int b = 1;
        change(b);
        System.out.println(b);
    }
}
