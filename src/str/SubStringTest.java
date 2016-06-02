package str;

/**
 * Created by qinbingbing on 6/2/16.
 */
public class SubStringTest {
    public static void main(String[] args) {
        String str = "a.b.c.";
        int i = str.lastIndexOf(".");
        System.out.println(i);
        str.substring(i + 1);
    }
}
