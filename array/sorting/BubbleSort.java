package array.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 1, 32, 8, 90, 65 };
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // time complexity=O(n^2)
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}