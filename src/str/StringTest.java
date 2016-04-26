package str;

import java.util.Arrays;

/**
 * Created by qinbingbing on 4/19/16.
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b1|b2";
        String c = "";
        System.out.println(Arrays.toString(a.split("\\|")));
        System.out.println(Arrays.toString(b.split("\\|")));
        System.out.println(Arrays.toString(b.split("|")));
    }
}
