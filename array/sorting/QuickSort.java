package array.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 1, 32, 8, 90, 65 };
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // time complexity=O(nlogn)
    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int idx = left - 1;
        int pivot = right;
        for (int i = left; i <= right; i++) {
            if (arr[i] < arr[pivot]) {

                swap(arr, ++idx, i);
            }
        }
        swap(arr, pivot, ++idx);
        return idx;
    }
}
