package algorithm;

import java.util.Arrays;

public class MaoPao {
    public static void bubbleSort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] >= arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 22, 1, 343, 12, 8};
        MaoPao.bubble(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void bubble(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] >= arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
