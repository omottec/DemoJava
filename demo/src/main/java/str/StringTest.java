package str;

/**
 * Created by qinbingbing on 21/02/2019.
 */
public class StringTest {
    public static void main(String[] args) {
//        regionMatches();
        length();
    }

    private static void regionMatches() {
        String str = "wss://www.example.com";
        boolean matchWs = str.regionMatches(true, 0, "ws:", 0, 3);
        boolean matchWss = str.regionMatches(true, 0, "wss:", 0, 4);
        System.out.println("matchWs:" + matchWs + ", matchWss:" + matchWss);
    }

    private static void length() {
        String str = "\"MTDP_tech\"";
        System.out.println(str + ":" + str.length());
        str = "\'MTDP_tech\'";
        System.out.println(str + ":" + str.length());
        str = "\'\'MTDP_tech\'\'";
        System.out.println(str + ":" + str.length());
        str = "0x";
        System.out.println(str + ":" + str.length());
    }
}
