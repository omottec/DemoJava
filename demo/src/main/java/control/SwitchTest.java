package control;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 09/10/2018.
 */
public class SwitchTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add(4);
//        list.add(5);
        switch (list.size()) {
            case 2:
                System.out.println("case 2");
            case 4:
                System.out.println("case 4");
                if(list.get(0) != 3) return;
                break;
            case 5:
                System.out.println("case 5");
                break;
            case 6:
                System.out.println("case 6");
                break;
            default:
                System.out.println("default");
                return;
        }
        System.out.println("after switch");
    }
}
