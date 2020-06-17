package jvm;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class Test0210 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ExecutionException, InterruptedException {
        long[] arr = new long[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        }
        // 单线程
        singleThreadSum(arr);

        // ForkJoinPool线程池
        forkJoinSum(arr);
    }
    private static void singleThreadSum(long[] arr) {
        long start = System.currentTimeMillis();

        Map<String, String> map = new HashMap<>(32);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // 模拟耗时，本文由公从号“彤哥读源码”原创
            sum += (arr[i]/3*3/3*3/3*3/3*3/3*3);
        }

        System.out.println("sum: " + sum);
        System.out.println("single thread elapse: " + (System.currentTimeMillis() - start));

    }

    private static void forkJoinSum(long[] arr) throws ExecutionException,InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(new SumTask(arr, 0, arr.length));
        // 获取结果
        Long sum = forkJoinTask.get();

        forkJoinPool.shutdown();

        System.out.println("sum: " + sum);
        System.out.println("fork join elapse: " + (System.currentTimeMillis() - start));
    }

    private static class SumTask extends RecursiveTask<Long>{
        private long[] arr;
        private int from;
        private int to;

        public SumTask(long[] arr, int from, int to) {
            this.arr = arr;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // 小于1000的时候直接相加，可灵活调整
            if (to - from <= 1000) {
                long sum = 0;
                for (int i = from; i < to; i++) {
                    // 模拟耗时
                    sum += (arr[i]/3*3/3*3/3*3/3*3/3*3);
                }
                return sum;
            }

            // 分成两段任务，本文由公从号“彤哥读源码”原创
            int middle = (from + to) / 2;
            SumTask left = new SumTask(arr, from, middle);
            SumTask right = new SumTask(arr, middle, to);

            // 提交左边的任务
            left.fork();
            // 右边的任务直接利用当前线程计算，节约开销
            Long rightResult = right.compute();
            // 等待左边计算完毕
            Long leftResult = left.join();
            // 返回结果
            return leftResult + rightResult;
        }
    }
}
