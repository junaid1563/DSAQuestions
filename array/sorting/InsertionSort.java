package array.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 1, 32, 8, 90, 65 };
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // time complexity=O(n^2)worst
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > current) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = current;
        }
    }
}
