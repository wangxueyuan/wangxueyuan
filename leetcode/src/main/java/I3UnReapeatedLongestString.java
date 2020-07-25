import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/6/2020 14:53
 * @Version: 1.0
 **/
public class I3UnReapeatedLongestString {
    public static int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) {
            return 1;
        }
        List<Character> list = new LinkedList<Character>();
        int count=1;
        for (char c : s.toCharArray()) {
            if (list.contains(c)) {
                if (list.size() > count) {
                    count = list.size();
                }

                list=list.subList(list.indexOf(c)+1, list.size());
            }
            list.add(c);
        }

        return Math.max(count, list.size());

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ajfdkojahohlfnlnf"));

    }

    //滑动窗口算法
    public static int unrepeatedLongestSubString(String s) {
        Set<Character> occ = new HashSet<Character>();
        int res=0,ans=0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (res<n&&!occ.contains(s.charAt(res))) {
                occ.add(s.charAt(res));
                res++;
            }
            ans = Math.max(ans, res - i);
        }
        return ans;
    }
}
