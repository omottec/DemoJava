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
        List<? super Teacher> superTeacher = new ArrayList<>();
        superTeacher.add(new Teacher());
//        superTeacher.add(new Person());
        Object object = superTeacher.get(0);

        List<? extends Person> extendsPerson = new ArrayList<>();
//        extendsPerson.add(new Teacher());
//        extendsPerson.add(new Person());
        Person person = extendsPerson.get(0);

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher());

        List<Person> persons = new ArrayList<>();
        persons.add(new Person());

        printTeacher(teachers);
//        printTeacher(persons);
//        printTeacher(superTeacher);
//        printTeacher(extendsPerson);

//        printPerson(teachers);
        printPerson(persons);
//        printPerson(extendsPerson);
//        printPerson(superTeacher);

        printSuperTeacher(persons);
        printSuperTeacher(teachers);
        printSuperTeacher(superTeacher);
//        printSuperTeacher(extendsPerson);

        printExtendsPerson(teachers);
        printExtendsPerson(persons);
        printExtendsPerson(extendsPerson);
//        printExtendsPerson(superTeacher);
    }


    private static void printTeacher(List<Teacher> teachers) {

    }

    private static void printPerson(List<Person> persons) {

    }

    private static void printSuperTeacher(List<? super Teacher> list) {

    }

    private static void printExtendsPerson(List<? extends Person> list) {};

}
