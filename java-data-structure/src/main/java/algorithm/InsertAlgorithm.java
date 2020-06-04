package algorithm;

import java.util.Arrays;

public class InsertAlgorithm {
    public static void InsertSort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1;j>=1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 22, 1, 343, 12, 8,32,15431,31,1,3431,13431,5426};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int[] arr) {
        if (arr.length > 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[i]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
