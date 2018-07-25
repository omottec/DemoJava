package dataStruct;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by omottec on 24/09/2017.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(2, 1);
        map.put(3, "a");
        map.put(7, "b");
        map.put(5, "c");
        System.out.println(map);
    }
}
