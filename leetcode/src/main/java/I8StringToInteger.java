import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/25/2020 15:37
 * @Version: 1.0
 **/
public class I8StringToInteger {
    public static int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        if (str.charAt(0) == ' ' || str.charAt(0) == '+' || str.charAt(0) == '-' || Character.isDigit(str.charAt(0))) {
            boolean negativeNum = false;
            List<Character> charList = new ArrayList<Character>();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    if (i > 0 && str.charAt(i - 1) == '-') {
                        negativeNum = true;
                    }
                    int index = i;
                    while (index < str.length() && Character.isDigit(str.charAt(index))) {
                        charList.add(str.charAt(index));
                        index++;
                    }
                    break;
                }
            }
            char[] res = new char[charList.size()];
            for (int i = 0; i < charList.size(); i++) {
                res[i] = charList.get(i);
            }
            String revers = new String(res);
            if (revers.isEmpty()) {
                return 0;
            }
            int result;
            if (revers.length() > 9) {
                String lastNum = revers.substring(revers.length() - 1);
                result = Integer.parseInt(revers.substring(0, 9));
                if (negativeNum) {
                    result -= 2 * result;
                }
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.parseInt(lastNum) > 7))
                    return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && Integer.parseInt(lastNum) < 8))
                    return Integer.MIN_VALUE;
            }
            result = Integer.parseInt(revers);
            if (negativeNum) {
                result -= 2 * result;
            }
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-"));
    }
}
