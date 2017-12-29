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
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Person());
        objectList.add(new Teacher());

        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        personList.add(new Teacher());

        List<? super Teacher> superTeacher = new ArrayList<>();
        superTeacher.add(new Teacher());
//        superTeacher.add(new Person());
        Object object = superTeacher.get(0);

        List<? extends Person> extendsPerson = new ArrayList<>();
//        extendsPerson.add(new Person());
//        extendsPerson.add(new Teacher());
        Person person = extendsPerson.get(0);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher());

        printTeacher(teacherList);
//        printTeacher(personList);
//        printTeacher(objectList);
//        printTeacher(superTeacher);
//        printTeacher(extendsPerson);

//        printPerson(teacherList);
        printPerson(personList);
//        printPerson(objectList);
//        printPerson(extendsPerson);
//        printPerson(superTeacher);

        printSuperTeacher(personList);
        printSuperTeacher(objectList);
        printSuperTeacher(teacherList);
        printSuperTeacher(superTeacher);
//        printSuperTeacher(extendsPerson);

        printExtendsPerson(teacherList);
        printExtendsPerson(personList);
//        printExtendsPerson(objectList);
        printExtendsPerson(extendsPerson);
//        printExtendsPerson(superTeacher);

//        printObject(teacherList);
//        printObject(personList);
        printObject(objectList);
//        printObject(superTeacher);
//        printObject(extendsPerson);

        printNoGenericList(teacherList);
        printNoGenericList(personList);
        printNoGenericList(objectList);
        printNoGenericList(extendsPerson);
        printNoGenericList(superTeacher);
    }


    private static void printTeacher(List<Teacher> list) {

    }

    private static void printPerson(List<Person> list) {

    }

    private static void printSuperTeacher(List<? super Teacher> list) {

    }

    private static void printExtendsPerson(List<? extends Person> list) {

    }

    private static void printObject(List<Object> list) {

    }

    private static void printNoGenericList(List list) {}

}
