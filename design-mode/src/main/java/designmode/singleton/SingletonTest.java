package designmode.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton1 test1=Singleton1.getInstance();
        Singleton1 test2 = Singleton1.getInstance();
        SingletonTest test3 = new SingletonTest();
        System.out.println(test1.equals(test2));
        System.out.println(test1.equals(test3));

        new Thread(()-> {
            System.out.println(SingletonDoubleCheck.getInstance().hashCode());
        }).start();
        new Thread(()-> {
            System.out.println(SingletonDoubleCheck.getInstance().hashCode());
        }).start();
        new Thread(()-> {
            System.out.println(SingletonDoubleCheck.getInstance().hashCode());
        }).start();
    }
}

//饿汉--未使用即创建
class Singleton1{
    private static Singleton1 instance =new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}

//懒汉
class Singleton2{
    private static Singleton2 instance;

    public static Singleton2 getInstance() throws InterruptedException {
        if (instance == null) {
            Thread.sleep(3000);
            instance = new Singleton2();
        }
        return instance;
    }
}

//懒汉--线程安全
class Singleton3{
    private static Singleton3 obj;

    synchronized public static Singleton3 getInstance() throws InterruptedException {
        Thread.sleep(3000);
        if (obj == null) {
            obj = new Singleton3();
        }
        return obj;
    }
}


//双检锁
class SingletonDoubleCheck{
    private static SingletonDoubleCheck instance;

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}

class SingletonLazy{
    private static SingletonLazy singleton;

    public static synchronized SingletonLazy getInstance() throws InterruptedException {
        Thread.sleep(300L);
        if (singleton == null) {
            singleton = new SingletonLazy();
        }
        return singleton;
    }
}