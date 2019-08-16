package generic;

import model.Person;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omottec on 23/02/2017.
 */
public class GenericTest {
    public static class Animal {}
    public static class Cat extends Animal {}
    public static void main(String[] args) {
        List noGenericList = new ArrayList();
        noGenericList.add(new Object());
        noGenericList.add(new Teacher());
        noGenericList.add(new Person());

        List<Object> objectList = new ArrayList<>();
        objectList.add(new Person());
        objectList.add(new Teacher());

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher());

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

        printTeacher(teacherList);
//        printTeacher(personList);
//        printTeacher(objectList);
        printTeacher(noGenericList);
//        printTeacher(superTeacher);
//        printTeacher(extendsPerson);

//        printPerson(teacherList);
        printPerson(personList);
//        printPerson(objectList);
        printPerson(noGenericList);
//        printPerson(superTeacher);
//        printPerson(extendsPerson);

        printSuperTeacher(teacherList);
        printSuperTeacher(personList);
        printSuperTeacher(objectList);
        printSuperTeacher(noGenericList);
        printSuperTeacher(superTeacher);
//        printSuperTeacher(extendsPerson);

        printExtendsPerson(teacherList);
        printExtendsPerson(personList);
//        printExtendsPerson(objectList);
        printExtendsPerson(noGenericList);
//        printExtendsPerson(superTeacher);
        printExtendsPerson(extendsPerson);

//        printObject(teacherList);
//        printObject(personList);
        printObject(objectList);
        printObject(noGenericList);
//        printObject(superTeacher);
//        printObject(extendsPerson);

        printNoGenericList(teacherList);
        printNoGenericList(personList);
        printNoGenericList(objectList);
        printNoGenericList(noGenericList);
        printNoGenericList(superTeacher);
        printNoGenericList(extendsPerson);
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
