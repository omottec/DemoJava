package ref;

/**
 * Created by qinbingbing on 4/5/16.
 */
public class StrongRefTest {
    public static void main(String[] args) {
        MyDate date = new MyDate();
//        System.gc();
        MemorySimulator.asyncDrainMemory();
    }
}
