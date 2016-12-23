package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 12/23/16.
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            strs.add(i + "");
        System.out.println(strs);
        strs.remove(1);
        strs.remove(1);
        System.out.println(strs);
    }
}
