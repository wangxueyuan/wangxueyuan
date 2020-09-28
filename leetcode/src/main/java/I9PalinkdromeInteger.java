/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/6/2020 15:43
 * @Version: 1.0
 **/
public class I9PalinkdromeInteger {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int revertInteger = 0;
        while (x > 0) {
            revertInteger = revertInteger * 10 + x % 10;
            x = x / 10;
        }
        return x == revertInteger || x == revertInteger / 10;
    }
}
