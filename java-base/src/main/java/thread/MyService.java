package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await 时间为" + System.currentTimeMillis());
            condition.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal() {
        try{
            lock.lock();
            System.out.println("signal时间为" + System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        new Thread(() -> myService.await()).start();
        Thread.sleep(3000);
        myService.signal();
    }
}
