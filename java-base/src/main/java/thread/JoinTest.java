package thread;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/21/2020 11:03
 * @Version: 1.0
 **/
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1");

        });
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.println("t2");

        });

        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main");
    }
}
