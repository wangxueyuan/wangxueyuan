package algorithm;

public class MergeAlgorithm {
    public static void mergeSort(int[] arr,int low,int high) {
        int mid=(low+high)/2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr,mid+1,high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        // 先建立一个临时数组，用于存放排序后的数据
        int[] tmpArr = new int[arr.length];

        int start1 = start, end1 = mid, start2 = mid + 1, end2 = end;
        // 创建一个下标
        int pos = start1;
        // 缓存左边数组的第一个元素的索引
        int tmp = start1;
        while (start1 <= end1 && start2 <= end2) {
            // 从两个数组中取出最小的放入临时数组
            if (arr[start1] <= arr[start2])
                tmpArr[pos++] = arr[start1++];
            else
                tmpArr[pos++] = arr[start2++];
        }
        // 剩余部分依次放入临时数组，实际上下面两个 while 只会执行其中一个
        while (start1 <= end1) {
            tmpArr[pos++] = arr[start1++];
        }
        while (start2 <= end2) {
            tmpArr[pos++] = arr[start2++];
        }
        // 将临时数组中的内容拷贝回原来的数组中
        while (tmp <= end) {
            arr[tmp] = tmpArr[tmp++];
        }

    }
}
