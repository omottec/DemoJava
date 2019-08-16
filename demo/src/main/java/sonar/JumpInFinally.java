package sonar;

/**
 * Created by qinbingbing on 16/08/2019.
 * Jump statements should not occur in "finally" blocks
 * Using return, break, throw, and so on from a finally block suppresses the propagation of any unhandled Throwable which was thrown in the try or catch block.
 * This rule raises an issue when a jump statement (break, continue, return, throw, and goto) would force control flow to leave a finally block.
 */
public class JumpInFinally {
    public static void main(String[] args) {
        try {
            doSomethingWhichThrowsException();
            System.out.println("OK");   // incorrect "OK" message is printed
        } catch (RuntimeException e) {
            System.out.println("ERROR");  // this message is not shown
        }
    }

    public static void doSomethingWhichThrowsException() {
        try {
            throw new RuntimeException();
        } finally {
            for (int i = 0; i < 10; i ++) {
                System.out.println("doSomething " + i);
            }
            return;      // Noncompliant - prevents the RuntimeException from being propagated
        }
    }
}
