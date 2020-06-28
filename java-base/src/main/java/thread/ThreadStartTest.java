package thread;

public class ThreadStartTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            System.out.println("aaa");

        },"tt");
        t.setDaemon(true);
        t.start();
        Thread.sleep(200);


    }
}
