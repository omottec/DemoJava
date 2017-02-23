package generic;

import model.Person;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omottec on 23/02/2017.
 */
public class GenericTest {
    public static void main(String[] args) {
        List<? super Teacher> list = new ArrayList<>();
        list.add(new Teacher());
//        list.add(new Person());
        Object object = list.get(0);

        List<? extends Person> list1 = new ArrayList<>();
//        list1.add(new Teacher());
        Person person = list1.get(0);

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher());

        List<Person> persons = new ArrayList<>();
        persons.add(new Person());



        print(persons);
        print(teachers);
        print(list);

        print1(teachers);
//        print1(persons);

    }


    private static void print(List<? super Teacher> list) {

    }

    private static void print1(List<Teacher> list) {

    }

}
