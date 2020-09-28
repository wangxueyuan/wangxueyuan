package thread;


import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class SemaphoreWorker implements Runnable {
    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        try {
            System.out.printf("Thread get semaphore->%s, is waiting for a permission\n",
                    Thread.currentThread().getName());
            semaphore.acquire();
            System.out.println("acquire a permission");
            System.out.println("executed");
            Thread.sleep(2000L);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();

        }
    }
}

public class SemaphoreTest {
    public static void main(String[] args) {
        System.out.println("Action...Go");
        Semaphore semaphore = new Semaphore(5);
        IntStream.range(0, 10).forEach(i -> new Thread(new SemaphoreWorker(semaphore)).start());
    }
}
