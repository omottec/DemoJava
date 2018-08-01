package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinbingbing on 12/23/16.
 */
public class ListTest {
    public static void main(String[] args) {
        testToArray();
    }

    private static void testRemove() {
        List<String> strs = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            strs.add(i + "");
        System.out.println(strs);
        strs.remove(1);
        strs.remove(1);
        System.out.println(strs);
    }

    private static void testModify() {
        List<String> strs = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            strs.add(i + "");
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
            strs.remove(i);
            System.out.println(strs);
        }
    }

    private static void testToArray() {
        List<String> list = new ArrayList<>();
        String[] strs = list.toArray(new String[list.size()]);
        System.out.println(strs);
        System.out.println(Arrays.toString(strs));
        System.out.println(strs.length == 0);
    }

}
