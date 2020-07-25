/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/6/2020 15:29
 * @Version: 1.0
 **/
public class I5LongestPalindromicSubString {
    public static String longestPalindrome(String s) {
        if (s==null||s.isEmpty()) {
            return s;
        }
        int res = 1;
        int start=-1;
        int end=-1;
        for (int i = 0; i < s.length()-1; i++) {
            int length = 0;
            int left=i;
            int right=i+1;
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    length += 2;
                    continue;
                }
                break;
            }
            int length1 = -1;
            int left1=i;
            int right1=i;
            while (left1 >= 0 && right1 <= s.length() - 1) {
                if (s.charAt(left1) == s.charAt(right1)) {
                    left1--;
                    right1++;
                    length1 += 2;
                    continue;
                }
                break;
            }
            if (length >= length1 && length > res) {
                res = length;
                start = left;
                end = right;
            } else if (length1 >= length && length1 > res) {
                res = length1;
                start = left1;
                end = right1;
            }
        }
        if (res == 1) {
            return s.substring(0,1);
        } else {
            return s.substring(start+1, end);
        }

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
