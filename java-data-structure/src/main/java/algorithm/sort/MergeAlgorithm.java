package algorithm.sort;

import java.util.Arrays;

public class MergeAlgorithm {
    public static void mergeSort(int[] arr,int low,int high) {
        int mid=(low+high)/2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr,mid+1,high);
            merge(arr, low, mid, high);
        }
    }

    private static void merges(int[] arr, int start, int mid, int end) {
        // 先建立一个临时数组，用于存放排序后的数据
        int[] tmpArr = new int[arr.length];

        int low = start, high = mid + 1;
        // 创建一个下标
        int index = low;
        // 缓存左边数组的第一个元素的索引
        int tmp = low;
        while (low <= mid && high <= end) {
            // 从两个数组中取出最小的放入临时数组
            if (arr[low] <= arr[high])
                tmpArr[index++] = arr[low++];
            else
                tmpArr[index++] = arr[high++];
        }
        // 剩余部分依次放入临时数组，实际上下面两个 while 只会执行其中一个
        while (low <= mid) {
            tmpArr[index++] = arr[low++];
        }
        while (high <= end) {
            tmpArr[index++] = arr[high++];
        }
        // 将临时数组中的内容拷贝回原来的数组中
        while (tmp <= end) {
            arr[tmp] = tmpArr[tmp++];
        }

    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr = new int[arr.length];
        int left = start, right = mid + 1;
        int index = left;
        int temp = left;
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                tempArr[index++] = arr[left++];
            } else {
                tempArr[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            tempArr[index++] = arr[left++];
        }
        while (right <= end) {
            tempArr[index++] = arr[right++];
        }
        while (temp <= end) {
            arr[temp] = tempArr[temp++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 22, 1, 343, 12, 8,32,15431,31,1,3431,13431,5426};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
