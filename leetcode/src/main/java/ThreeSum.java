import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            //设定标杆数，如果该数之前已经设置过，则跳过
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > 0)
                break;
            int first = i + 1;
            int last = length - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    /*
                        这个first++,last--,
                        如果我们当前匹配成功的话,为了避免重复,当前的两个搭档肯定是不能用的
                        所以这里first++,last--
                        当然你只写first++或者last--也是可以的,不过时间上可能会慢点
                     */
                    first++;
                    last--;
                    // 如果当前first和上一个我们已经匹配过first相等 first++
                    while (first < last && nums[first] == nums[first - 1])
                        first++;
                    // 如果当前last和上一个我们已经匹配过的last相等,last--
                    while (first < last && nums[last] == nums[last + 1])
                        last--;
                } else if (sum > 0) {
                    last--;
                } else {
                    first++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
