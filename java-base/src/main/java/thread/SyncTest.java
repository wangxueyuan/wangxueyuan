package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.IntStream;

public class SyncTest {
    private static class Sync extends AbstractQueuedSynchronizer{
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int release) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    private final Sync sync = new Sync();
    public void lock() {
        sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(0);
    }

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        SyncTest syncTest = new SyncTest();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        IntStream.range(0,1000).forEach(i->new Thread(()->{
            syncTest.lock();
            try{
                IntStream.range(0,10000).forEach(j->{
                    count++;
                });
            }finally {
                syncTest.unlock();
            }
        },"tt-"+i).start());
        countDownLatch.await();
        System.out.println(count);
    }

}
