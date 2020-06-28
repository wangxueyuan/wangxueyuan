package other;

public class BitManipulation {
    public static void main(String[] args) {
        int i=3;
        System.out.println(Integer.toBinaryString(i));
        i >>= 2;
        System.out.println(Integer.toBinaryString(i));
    }
}
