package array.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 1, 32, 8, 90, 65 };
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // time complexity=O(n^2)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE, minIndex = 0;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
