package algorithm;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/10/2020 09:43
 * @Version: 1.0
 **/
public class BinarySearch {
    public static int binarySearch(int[] arr, int low,int high, int target) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] < target) {
                low = middle + 1;
            }
            if (arr[middle] > target) {
                high = high - 1;
            }
            return middle;
        }
        return -1;
    }
}
