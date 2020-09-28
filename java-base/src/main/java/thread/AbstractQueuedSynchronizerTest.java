package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.IntStream;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/13/2020 21:22
 * @Version: 1.0
 **/
public class AbstractQueuedSynchronizerTest {
    private static int count = 0;
    private final Sync sync = new Sync();

    public static void main(String[] args) throws InterruptedException {
        AbstractQueuedSynchronizerTest lock = new AbstractQueuedSynchronizerTest();

        CountDownLatch countDownLatch = new CountDownLatch(1000);

        IntStream.range(0, 1000).forEach(i -> new Thread(() -> {
            lock.lock();

            try {
                IntStream.range(0, 10000).forEach(j -> {
                    count++;
                });
            } finally {
                lock.unlock();
            }
//            System.out.println(Thread.currentThread().getName());
            countDownLatch.countDown();
        }, "tt-" + i).start());

        countDownLatch.await();

        System.out.println(count);
    }

    public void lock() {
        sync.acquire(1);

    }

    public void unlock() {
        sync.release(1);
    }

    // 定义一个同步器，实现AQS类
    private static class Sync extends AbstractQueuedSynchronizer {
        // 实现tryAcquire(acquires)方法
        @Override
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 实现tryRelease(releases)方法
        @Override
        protected boolean tryRelease(int releases) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }
}
