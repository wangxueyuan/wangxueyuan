/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/21/2020 11:28
 * @Version: 1.0
 **/
public class I26DeleteRepeatedNumInArr {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int index = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                index--;
                for (int j = i - 1; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return index;
    }
}
