package regex;

public class RegexStudy {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("34334".matches("-?\\d+"));
    }
}
