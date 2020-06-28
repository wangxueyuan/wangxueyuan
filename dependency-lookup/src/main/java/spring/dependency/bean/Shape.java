package spring.dependency.bean;

public class Shape {
    private Circle circle1;

    public Shape() {

    }

    public Shape(Circle circle) {
        this.circle1 = circle;
    }

    public void setCircle1(Circle circle1) {
        this.circle1 = circle1;
    }

    public Circle getCircle1() {
        return circle1;
    }

}
