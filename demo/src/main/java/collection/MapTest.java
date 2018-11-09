package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinbingbing on 18/10/2018.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "aaa");
        map.put(new Integer(1), "aaa");
        System.out.println(map.get(1));

//        Object[] objects = new Object[Long.MAX_VALUE];
        Object[] objects = new Object[Integer.MAX_VALUE];
        int length = objects.length;
    }
}
