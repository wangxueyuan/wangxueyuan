package reflect.Pets;

public class Pet {
    private static long counter;
    private long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + "_" + id;
    }
}
