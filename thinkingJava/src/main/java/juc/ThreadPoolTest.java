package juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class TaskWithResult implements Callable<String>{
    private int id=0;

    public TaskWithResult(int id) {
        this.id=id;
    }
    @Override
    public String call() throws Exception {
        System.out.println("hello"+id);
        return "the result is "+this.id;
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadFactory myFactory = new ThreadFactoryBuilder().setNameFormat("Test_wxy_%s").build();
        ExecutorService executorService = new ThreadPoolExecutor(1, 5, 0L,TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), myFactory,
                new ThreadPoolExecutor.AbortPolicy());
        List<FutureTask> futureTaskList = new ArrayList<>();
        int id=10;
        for (int i = 0; i < 10; i++) {
            futureTaskList.add((FutureTask) executorService.submit(new TaskWithResult(id--)));
        }

        for (Future<String> fs : futureTaskList) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
