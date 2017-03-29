package ref;

/**
 * Created by qinbingbing on 4/5/16.
 */
public class ImplicitGcTest {
    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
        MemorySimulator.asyncDrainMemory();
    }
}
