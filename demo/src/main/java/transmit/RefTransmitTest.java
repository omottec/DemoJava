package transmit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by qinbingbing on 28/05/2018.
 */
public class RefTransmitTest {
    public static void main(String[] args) {
        testList();
    }

    private static void testList() {
        List<String> orgList = new ArrayList<>();
        orgList.add("a");
        orgList.add("b");
        orgList.add("c");

        List<String> newList = new ArrayList<>();
        newList.add("c");
        newList.add("d");
        System.out.println("before filter orgList:" + orgList);
        System.out.println("before filter newList:" + newList);
        System.out.println("-----------------------");
        filterList(newList, orgList);
        System.out.println("after filter orgList:" + orgList);
        System.out.println("after filter newList:" + newList);
    }

    private static void filterList(List<String> newList, List<String> oldList) {
        if (newList == null || newList.isEmpty()) return;
        if (oldList == null || oldList.isEmpty()) return;
        Iterator<String> it = newList.iterator();
        String s = null;
        while (it.hasNext()) {
            s = it.next();
            for (String item : oldList) {
                if (s.equals(item)) {
                    it.remove();
                    break;
                }
            }
        }
    }
}
