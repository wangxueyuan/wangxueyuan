package thread;

public class Test {
    public static void main(String[] args) {
        HasSelfPrivateNum hspn = new HasSelfPrivateNum();

        Ta ta = new Ta(hspn);
        ta.run();

        Tb tb = new Tb(hspn);
        tb.run();
    }
}
