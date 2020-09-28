package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {13, 22, 1, 343, 12, 8, 9, 324, 22, 13};
        System.out.println(getKMaxElement(arr, 0, arr.length - 1, 3));

        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int low = left, high = right;
        //pivot为右选第一个，那循环时从左边开始，如果pivot选取左边第一个，那循环从右边开始
        int pivot = arr[right];
        while (low < high) {
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
            }
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
            }
        }
        //这里arr[low]或者arr[high】均可以，因为此时两个指针已经重叠了
        arr[low] = pivot;
        sort(arr, left, low - 1);
        sort(arr, high + 1, right);
    }

    //获取第K大元素
    public static int getKMaxElement(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return arr[left];
        }

        int low = left, high = right;
        //pivot为右选第一个，那循环时从左边开始，如果pivot选取左边第一个，那循环从右边开始
        int pivot = arr[right];
        while (low < high) {
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
            }
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
            }
        }
        arr[low] = pivot;
        if (low == arr.length - k) {
            return arr[low];
        } else if (low > arr.length - k) {
            return getKMaxElement(arr, left, low - 1, k);
        } else {
            return getKMaxElement(arr, high + 1, right, k);
        }
    }


}
