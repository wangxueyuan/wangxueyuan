package spring.dependency.lookup.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dependency.bean.Shape;

public class TestAutowiring {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/autowiring.xml");

        Shape shape = (Shape) ctx.getBean("noAutoWiring");
        System.out.println("noAutoWiring : " + shape.getCircle1().getCenter()
                + " " + shape.getCircle1().getRadio());

        Shape shape1 = (Shape) ctx.getBean("getCircleByName");
        System.out.println("getCircleByName: " + shape1.getCircle1().getCenter()
                + " " + shape1.getCircle1().getRadio());

        Shape shape2 = (Shape) ctx.getBean("getCircleByType");
        System.out.println("getCircleByType: " + shape2.getCircle1().getCenter()
                + " " + shape2.getCircle1().getRadio());

        Shape shape3 = (Shape) ctx.getBean("getCircleCst");
        System.out.println("getCircleCst: " + shape3.getCircle1().getCenter()
                + " " + shape3.getCircle1().getRadio());

        Shape shape4 = (Shape) ctx.getBean("getCircleAdt");
        System.out.println("getCircleAdt: " + shape4.getCircle1().getCenter()
                + " " + shape4.getCircle1().getRadio());

    }
}
