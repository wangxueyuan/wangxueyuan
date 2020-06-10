package designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Beautiful beautiful = new Beautiful();
        InvocationHandlerTest invocationHandlerTest = new InvocationHandlerTest();
        invocationHandlerTest.setObj(beautiful);
        Girl girl = (Girl) invocationHandlerTest.getProxyInstance();
        girl.date();
        girl.watchMovie();
    }
}

interface Girl {
    void date();

    void watchMovie();
}

class Beautiful implements Girl {

    @Override
    public void date() {
        System.out.println("I'm dating...");
    }

    @Override
    public void watchMovie() {
        System.out.println("I'm watching movie...");
    }
}

class UglyGirl implements Girl {

    @Override
    public void date() {
        System.out.println("I'm not dating...");
    }

    @Override
    public void watchMovie() {
        System.out.println("I'm not watching a movie...");
    }
}

class InvocationHandlerTest implements InvocationHandler {
    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    private Object obj;
    InvocationHandlerTest() {
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Handler invoke...");
        Object object = method.invoke(obj, objects);
        return object;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
}