package generic;

import junit.framework.TestCase;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 01/04/2017.
 */
public class GenericTest extends TestCase {

    public void testParameterizedType() {
        List<String> strList = new ArrayList<>();
        Type type  = strList.getClass();
        if (!(type instanceof ParameterizedType)) return;
        ParameterizedType t = (ParameterizedType) type;
        Type ownerType = t.getOwnerType();
        System.out.println(ownerType);

        Type rawType = t.getRawType();
        System.out.println(rawType);

        Type[] actualTypeArguments = t.getActualTypeArguments();
        if (actualTypeArguments == null) return;
        for (Type arg : actualTypeArguments)
            System.out.println(arg);
    }

    public void testTypeVariable() {
        List<String> strList = new ArrayList<>();
        TypeVariable<? extends Class<? extends List>>[] typeVariables = strList.getClass().getTypeParameters();
        System.out.println(typeVariables[0].getName());
        System.out.println(typeVariables[0].getGenericDeclaration());
    }
}
