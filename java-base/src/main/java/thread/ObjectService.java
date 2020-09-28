package thread;

import java.util.stream.IntStream;

public class ObjectService {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
                threadLocal.set(3);
                Integer value = threadLocal.get();
                while (value < 10) {
                    System.out.printf("Thread name is %s,value is %d \n", Thread.currentThread().getName(), value++);
                }
            }).start();
        });
    }
}
