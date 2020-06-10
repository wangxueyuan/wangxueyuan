package designmode.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton1 test1=Singleton1.getInstance();
        Singleton1 test2 = Singleton1.getInstance();
        SingletonTest test3 = new SingletonTest();
        System.out.println(test1.equals(test2));
        System.out.println(test1.equals(test3));

        new Thread(()-> {
            try {
                System.out.println(Singleton4.getInstance().hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                System.out.println(Singleton4.getInstance().hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                System.out.println(Singleton4.getInstance().hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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


//
class Singleton4{
    private static Singleton4 instance;

    public static Singleton4 getInstance() throws InterruptedException {
        Thread.sleep(3000);
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}