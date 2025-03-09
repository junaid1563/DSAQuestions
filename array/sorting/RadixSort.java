package array.sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 121, 3, 2, 4, 5, 3, 4, 90, 234 };
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1;
        for (int i = max; i > 0; i /= 10) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        int[] bucket = new int[10];
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] / exp % 10;
            bucket[digit]++;
        }
        // sum bucket values
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            ans[bucket[digit]-1] = arr[i];
            bucket[digit]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }
}
