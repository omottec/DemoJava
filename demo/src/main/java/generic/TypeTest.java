package generic;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by qinbingbing on 01/04/2017.
 */
public class TypeTest<T> {
    public TypeTest() {}
    public <E> TypeTest(E e) {}
    public Map<T, String> genericField;
    public <B> Map<Integer, String>[] genericMethod(List<? extends Integer> list,List<String> list1,
                                                    String str, B[] tArr) {
        return null;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class<TypeTest> clazz = TypeTest.class;
        System.out.println("Generic Field");
        Field field = clazz.getField("genericField");
        actualType(field.getGenericType());
        System.out.println();

        System.out.println("Generic Method Return Type");
        Method method = clazz.getMethod("genericMethod", List.class, List.class, String.class, Object[].class);
        actualType(method.getGenericReturnType());
        System.out.println();

        System.out.println("Generic Method Parameter");
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (int i = 0, length = genericParameterTypes.length; i < length; i++)
            actualType(genericParameterTypes[i]);
        System.out.println();

        System.out.println("Generic Constructor Parameter");
        Constructor<?> constructor = clazz.getConstructor(Object.class);
        Type[] parameterTypes = constructor.getGenericParameterTypes();
        for (int i = 0, length = parameterTypes.length; i < length; i++)
            actualType(parameterTypes[i]);
        System.out.println();
    }

    private static void actualType(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.println(String.format("type %s is TypeVariable", t.getName()));
        } else if (type instanceof WildcardType) {
            System.out.println("type is WildcardType");
        } else if (type instanceof Class) {
            Class<?> c = (Class<?>) type;
            System.out.println(String.format("type is Class %s", c.getCanonicalName()));
        } else if (type instanceof ParameterizedType) {
            System.out.println("type is ParameterizedType");
            ParameterizedType t = (ParameterizedType) type;
            Type[] actualTypeArguments = t.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                if (actualTypeArguments[i] instanceof TypeVariable) {
                    System.out.println(String.format("arg %d is TypeVariable %s", i, actualTypeArguments[i]));
                } else if (actualTypeArguments[i] instanceof WildcardType) {
                    System.out.println(String.format("arg %d is WildcardType %s", i, actualTypeArguments[i]));
                } else if (actualTypeArguments[i] instanceof Class) {
                    System.out.println(String.format("arg %d is Class %s", i, ((Class)actualTypeArguments[i]).getCanonicalName()));
                }
            }
        } else if (type instanceof GenericArrayType) {
            System.out.println("type is GenericArrayType");
            GenericArrayType t = (GenericArrayType) type;
            Type componentType = t.getGenericComponentType();
            if (componentType instanceof TypeVariable) {
                System.out.println(String.format("componentType is TypeVariable %s", componentType));
            } else if (componentType instanceof ParameterizedType) {
                System.out.println(String.format("componentType is ParameterizedType %s", componentType));
                ParameterizedType pt = (ParameterizedType) componentType;
                actualType(pt);
            }
        }
    }
}
