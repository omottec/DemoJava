package access;

/**
 * Created by omottec on 17/02/2017.
 */
public class OutClass {
    private String privateField = "I am a privateField";
    String defaultField = "I am a defaultField";
    protected String protectedField = "I am a protectedField";
    public String publicField = "I am a publicField";
    private String field = new InPrivateClass().privateStr;

    private class InPrivateClass {
        private String privateStr = "I am a privateStr";
        String defaultStr = "I am a defaultStr";
        protected String protectedStr = "I am a protectedStr";
        public String publicStr = "I am a publicStr";

        String str = privateField;
    }

    class InDefaultClass {
        private String privateStr = "I am a privateStr";
        String defaultStr = "I am a defaultStr";
        protected String protectedStr = "I am a protectedStr";
        public String publicStr = "I am a publicStr";

        String str = privateField;
    }

    protected class InProtectedClass {
        private String privateStr = "I am a privateStr";
        String defaultStr = "I am a defaultStr";
        protected String protectedStr = "I am a protectedStr";
        public String publicStr = "I am a publicStr";

        String str = privateField;
    }

    public class InPublicClass {
        private String privateStr = "I am a privateStr";
        String defaultStr = "I am a defaultStr";
        protected String protectedStr = "I am a protectedStr";
        public String publicStr = "I am a publicStr";

        String str = privateField;
    }

    public static class InPublicStaticClass {
        private String privateStr = "I am a privateStr";
        String defaultStr = "I am a defaultStr";
        protected String protectedStr = "I am a protectedStr";
        public String publicStr = "I am a publicStr";

//        String str = privateField;
    }
}
