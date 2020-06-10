package designmode.singleton;

public class RunTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(MyObject.getInstance().hashCode())).start();
        new Thread(() -> System.out.println(MyObject.getInstance().hashCode())).start();
        new Thread(() -> System.out.println(MyObject.getInstance().hashCode())).start();
    }
}
