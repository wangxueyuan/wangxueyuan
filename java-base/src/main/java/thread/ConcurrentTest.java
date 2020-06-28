package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newWorkStealingPool();
        int max=Integer.MAX_VALUE;
        System.out.println(max+1);
    }
}