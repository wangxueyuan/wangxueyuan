/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/25/2020 16:53
 * @Version: 1.0
 **/
public class I14LongestCommonPrefix {
    public static String getLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        boolean flag = true;
        int end = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            sb.append(strs[0].charAt(i));
            end++;
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i > str.length() || !str.substring(0, i + 1).equals(sb.toString())) {
                    end = i - 1;
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        if (end == -1) {
            return "";
        } else {
            return sb.toString().substring(0, end + 1);
        }
    }

    public static void main(String[] args) {
        String[] list = {"c", "c"};
        System.out.println(getLongestCommonPrefix(list));
    }
}
