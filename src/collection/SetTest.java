package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qinbingbing on 4/18/16.
 */
public class SetTest {


    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        Set<String> s = new HashSet<String>();
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
        System.out.println("s1.add(a):" + s1.add(a));
        System.out.println("s1.add(b):" + s1.add(b));
        System.out.println("s2.add(b):" + s2.add(b));
        System.out.println("s2.add(c):" + s2.add(c));
        System.out.println("s.addAll(s1):" + s.addAll(s1));
        System.out.println("s.addAll(s2):" + s.addAll(s2));
    }
}
