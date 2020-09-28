package thread;

import java.util.concurrent.CountDownLatch;

public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(3);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    c.countDown();
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("r1");
            }
        };
        Runnable r2=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    c.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("r2");
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        c.await();
        System.out.println("All finished");
    }
}
