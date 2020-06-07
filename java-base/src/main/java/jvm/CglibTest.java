package jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        CglibTest clt= (CglibTest) enhancer.create();
        clt.test();
        System.out.println(clt);
    }
    public void test() {
        System.out.println("CgLibTest);");
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.err.println("Before invoke"+method);
            Object ob = methodProxy.invokeSuper(o, objects);
            System.err.println("After invoke"+method);
            return ob;
        }
    }

}
