package designmode.singleton;

public class MyObject {
    private static MyObject myObject = new MyObject();
    private MyObject(){}

    public static MyObject getInstance() {
        return myObject;
    }
}
