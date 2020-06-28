package innerclass;

public class InnerTest {
    String outer = "outer";
    class Inner{
       String test =outer+ "aaa";
    }

    public Inner getInner() {
        return this.new Inner();
    }
    public static void main(String[] args) {
        InnerTest innerTest = new InnerTest();
        InnerTest.Inner inner = innerTest.getInner();
        System.out.println(inner.test);
    }
}
