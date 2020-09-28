package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;


class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(200L);
        System.out.println(System.currentTimeMillis());
        return Thread.currentThread().getName();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
    }
}

public class ConcurrentTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newWorkStealingPool();
        List<Callable<String>> tasks = new ArrayList<>();
        LongStream.range(0, 10).forEach(i -> {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tasks.add(new MyCallable());
        });
        String name = executors.invokeAny(tasks);
        /*for (Future<Long> future : futures) {
            System.out.println(future.get());
        }*/
        System.out.println(name);
    }
}