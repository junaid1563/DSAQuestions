package array.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 1, 32, 8, 90, 65 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // time complexity=O(nlogn)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int left1 = left, right1 = mid, left2 = mid + 1, right2 = right;
        int[] temp = new int[right - left + 1];
        int i = left1, j = left2, k = 0;
        while (i <= right1 && j <= right2) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= right1) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right2) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // modify existing array
        for (int x = 0; x < temp.length; x++) {
            arr[x + left1] = temp[x];
        }

    }
}
