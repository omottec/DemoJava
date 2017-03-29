package access1;

import access.OutClass;

/**
 * Created by omottec on 17/02/2017.
 */
public class AnotherPkgClass {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.new InPublicClass();
        new OutClass().new InPublicClass();
        new OutClass.InPublicStaticClass();
    }
}
