package nullTest;

import model.Pet;

/**
 * Created by qinbingbing on 5/28/16.
 */
public class NullTest {
    public static void main(String[] args) {
        Object obj = null;
        Pet pet = (Pet)obj;
        System.out.println(obj);
        System.out.println(pet);
        System.out.println("prefix " + obj);

        int i = 2;
        Integer integer = null;
        System.out.println(i + " " + integer);
        i = integer;
        System.out.println(i + " " + integer);
    }
}
