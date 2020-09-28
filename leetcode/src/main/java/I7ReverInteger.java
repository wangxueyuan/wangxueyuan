import java.util.Stack;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/25/2020 14:27
 * @Version: 1.0
 **/
public class I7ReverInteger {
    //无法避免超过Integer.max
    public static int reverse(int x) {
        Stack<Character> stack = new Stack<Character>();
        String s = String.valueOf(x);
        boolean negativeNum = false;
        for (Character c : s.toCharArray()) {
            if (c.equals('-')) {
                negativeNum = true;
                continue;
            }
            stack.push(c);
        }
        char[] array = new char[negativeNum == true ? s.length() - 1 : s.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        String revers = new String(array);
        int result;
        if (revers.length() > 1) {
            String lastNum = revers.substring(revers.length() - 1);
            result = Integer.parseInt(revers.substring(0, revers.length() - 1));
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.parseInt(lastNum) > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && Integer.parseInt(lastNum) < -8))
                return 0;
        }

        result = Integer.parseInt(revers);
        if (negativeNum) {
            result -= 2 * result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(0));
    }
}
