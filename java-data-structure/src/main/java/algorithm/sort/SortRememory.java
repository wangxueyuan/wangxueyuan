package algorithm.sort;

import java.util.Arrays;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/25/2020 19:55
 * @Version: 1.0
 **/
public class SortRememory {
    public static void bubble(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void select(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            int base = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < base) {
                    index = j;
                    base = array[j];
                }
            }
            array[index] = array[i];
            array[i] = base;
        }
    }

    public static void insert(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void merge(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            merge(array, low, mid);
            merge(array, mid + 1, high);
            mergeArray(array, low, mid, high);
        }
    }

    private static void mergeArray(int[] array, int low, int mid, int high) {
        int[] tmpArray = new int[array.length];
        int left = low, right = mid + 1;
        int index = low;
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                tmpArray[index++] = array[left++];
            } else {
                tmpArray[index++] = array[right++];
            }
        }
        while (left <= mid) {
            tmpArray[index++] = array[left++];
        }
        while (right <= high) {
            tmpArray[index++] = array[right++];
        }
        int tmp = low;
        while (tmp <= high) {
            array[tmp] = tmpArray[tmp++];
        }
    }

    public static void quick(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start, right = end;
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && array[left] < pivot) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[left] = pivot;
        quick(array, start, left - 1);
        quick(array, left + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {324, 1341, 143, 123, 34, 8, 31414, 31431, 4313};
//        bubble(array);
//        select(array);
//        insert(array);
//        merge(array,0,array.length-1);
        quick(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
