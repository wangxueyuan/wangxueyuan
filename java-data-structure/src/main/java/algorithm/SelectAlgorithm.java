package algorithm;

import java.util.Arrays;

public class SelectAlgorithm {
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];
            int index=i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    index=j;
                }
            }
            arr[index] = arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 22, 1, 343, 12, 8};
        SelectAlgorithm.select(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void select(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
