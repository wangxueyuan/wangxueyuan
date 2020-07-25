import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/7/2020 17:36
 * @Version: 1.0
 **/
public class I1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
