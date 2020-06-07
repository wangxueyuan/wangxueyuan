package designmode.factorymethod;

public class FactoryMethodTest {

}

interface Product {
    void method1();
}

class ProductA implements Product {

    @Override
    public void method1() {
        System.out.println("ProductA");
    }
}

class ProductB implements Product {

    @Override
    public void method1() {
        System.out.println("ProductB");
    }
}

class SimpleFactory {
    public static Product createProduct(String type) {
        if (type.equals("1")) {
            return new ProductA();
        } else if (type.equals("2")) {
            return new ProductA();
        }
        return null;
    }
}

class Application {
    private Product createProduct(String type) {
        return SimpleFactory.createProduct(type);
    }

    public Product getObject() {
        Product p = createProduct("dfafd");
        return p;
    }
}