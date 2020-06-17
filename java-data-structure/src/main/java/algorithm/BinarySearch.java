package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/10/2020 09:43
 * @Version: 1.0
 **/
public class BinarySearch {
    //查找值等于目标数的位置
    public static int binarySearch(int[] arr, int low,int high, int target) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] < target) {
                low=middle+1;

            }
            if (arr[middle] > target) {
                high = middle - 1;
            }
            return binarySearch(arr, low, high, target);
        }
        return -1;
    }

    //查找第一个等于目标数的位置
    public static int binarySearchFistMatch(int[] arr, int low,int high, int target) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == target) {
                if(middle==0||arr[middle-1]!=target)
                    return middle;
                else
                    high = middle - 1;
            }

            if (arr[middle] < target) {
                low=middle+1;

            }
            if (arr[middle] > target) {
                high = middle - 1;
            }
        }
        return -1;
    }

    //查找最后一个等于目标数的位置
    public static int binarySearchLastMatch(int[] arr, int low,int high, int target) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == target) {
                if(middle==arr.length-1||arr[middle+1]!=target)
                    return middle;
                else
                    low = middle + 1;
            }

            if (arr[middle] < target) {
                low=middle+1;

            }
            if (arr[middle] > target) {
                high = middle - 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于目标数的位置
    public static int binarySearchFistMatchOrOver(int[] arr, int low,int high, int target) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] >= target) {
                if(middle==0||arr[middle-1]<target)
                    return middle;
                else
                    high = middle - 1;
            }

            if (arr[middle] < target) {
                low=middle+1;

            }

        }
        return -1;
    }

    //查找最后一个小于等于目标数的位置
    public static int binarySearchLastMatchOrBelow(int[] arr, int low,int high, int target) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] <= target) {
                if(middle==arr.length-1||arr[middle+1]>target)
                    return middle;
                else
                    low = middle + 1;
            }


            if (arr[middle] > target) {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArr = {34, 34, 35, 55, 68, 111, 1111, 1111, 2222, 3333, 4444, 4444, 4444};
        List<Integer> list = Arrays.asList(34, 3234, 314);
        Collections.sort(list);
        System.out.println(binarySearch(testArr,0,testArr.length,111));
        System.out.println(binarySearchFistMatch(testArr,0,testArr.length,34));
        System.out.println(binarySearchLastMatch(testArr,0,testArr.length,34));
        System.out.println(binarySearchFistMatchOrOver(testArr, 0, testArr.length, 78));
        System.out.println(binarySearchLastMatchOrBelow(testArr,0,testArr.length,3335));
        System.out.println(6432>>5);
    }
}
