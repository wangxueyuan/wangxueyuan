package jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class AdderTest {
    public static void main(String[] args) {

    }

    static void testAtomicLongVSLongAdder(final int threadCount, final int times) {
        System.out.println("threadcount:" + threadCount + ",times:" + times);
        long start=System.currentTimeMillis();
        testLongAdder(threadCount, times);
        long end = System.currentTimeMillis();
        System.out.println("longAdder elapse:" + (end - start) + "ms");
    }

    private static void testLongAdder(int threadCount, int times) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        LongAdder longAdder = new LongAdder();
        LongStream.range(0, threadCount).forEach(i -> executorService.submit(()-> IntStream.range(0,times).forEach(j->longAdder.add(1))));
        System.out.println("longadder result"+longAdder.sum());
    }
}
