package clazz;

import model.Dog;
import model.Person;
import model.Teacher;
import ref.ReferentObject;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by qinbingbing on 20/11/2018.
 */
public class ClazzTest {
    public static void main(String[] args) {
//        testAssignable();
//        testAsSubclass();
        testDefaultValue();
    }

    private static void testAssignable() {
        System.out.println(Number.class.isAssignableFrom(Integer.class));
        System.out.println(Map.class.isAssignableFrom(SortedMap.class));
    }

    private static void testAsSubclass() {
        testNewInstance(Person.class);
        testNewInstance(Teacher.class.asSubclass(Person.class));
        testNewInstance(Teacher.class);
        testNewInstance(Dog.class);
    }

    private static void testNewInstance(Class<?> clazz) {
        try {
            Object o = clazz.newInstance();
            System.out.println(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void testDefaultValue() {
        ReflectObject reflectObject = new ReflectObject();
        System.out.println("reflectObject:" + reflectObject);
        try {
            ReflectObject reflectObject1 = (ReflectObject) Class.forName("clazz.ReflectObject").newInstance();
            System.out.println("reflectObject1:" + reflectObject1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ReflectObject reflectObject2 = ReflectObject.class.newInstance();
            System.out.println("reflectObject2:" + reflectObject2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
