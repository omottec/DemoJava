package equals;



/**
 * Created by qinbingbing on 4/28/16.
 */
public class EqualTest {
    public static void main(String[] args) {
        String a = null;
        String b = null;
        String str0 = "aaa";
        String str1 = "aaa";
        String str2 = new String("aaa");
        String str3 = new String("aaa");
        System.out.println("a == b: " + (a == b));
        System.out.println("str0 == str1: " + (str0 == str1));
        System.out.println("str2 == str3: " + (str2 == str3));
        System.out.println("str0 == str2: " + (str0 == str2));

        Integer int0 = 12;
        Integer int1 = 12;
        Integer int2 = new Integer(12);
        Integer int3 = new Integer(12);
        System.out.println("int0 == int1: " + (int0 == int1));
        System.out.println("int2 == int3: " + (int2 == int3));
        System.out.println("int0 == int2: " + (int0 == int2));

//        System.out.printf("str0.equals(a): " + str0.equals(a));
//        System.out.println("a.equals(str0): " + a.equals(str0));
    }
}
