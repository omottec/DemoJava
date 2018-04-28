package construct;

import sun.misc.Unsafe;

/**
 * Created by qinbingbing on 28/04/2018.
 */
public class UnsafeTest {
    public static void main(String[] args) {
        testGetUnsafe();
    }

    private static void testGetUnsafe() {
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe);
    }
}


