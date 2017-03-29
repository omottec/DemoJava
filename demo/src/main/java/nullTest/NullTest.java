package nullTest;

import model.Pet;

/**
 * Created by qinbingbing on 5/28/16.
 */
public class NullTest {
    public static void main(String[] args) {
        Object obj = null;
        Pet pet = (Pet)obj;
        System.out.println(pet);
    }
}
