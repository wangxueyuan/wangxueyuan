package designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(),handler);
        proxyHello.sayHello();
    }
}

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello{

    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object object;

    public MyInvocationHandler(Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Invoking sayHello");
        Object myObject = method.invoke(object, args);
        return myObject;
    }
}