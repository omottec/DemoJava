package str;

import java.util.Arrays;

/**
 * Created by qinbingbing on 4/19/16.
 */
public class SplitTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b1|b2";
        String c = "";
        System.out.println(Arrays.toString(a.split("\\|")));
        System.out.println(Arrays.toString(b.split("\\|")));
        System.out.println(Arrays.toString(b.split("|")));
        System.out.println(b.contains("|"));
        System.out.println(b.contains("\\|"));
        String ip = "1.1.1.1:8080";
        if (ip.contains(":")) {
            String[] split = ip.split(":");
            System.out.println(Arrays.toString(split));
        }
    }
}
