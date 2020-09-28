import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 8/5/2020 18:39
 * @Version: 1.0
 **/
public class list {
    public static void main(String[] args) {
        List<Integer> list = ImmutableList.of(1, 3, 5, 6);
//        list.stream().flatMap(v->v+1).forEach(System.out::println);

    }

    public static int findPeak(int[] nums) {
        if (nums != null && nums.length > 0) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums[0] > nums[1]) {
                return 0;
            }
            int tail = nums.length - 1;
            if (nums[tail] > nums[tail - 1]) {
                return tail;
            }
            int start = 0;
            while (start < tail) {
                int mid = start + (tail - start) / 2;

            }
        }
        return 0;
    }

}
