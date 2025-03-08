package array.sorting;

public class ReversingSubArrayToSort {
    /*
     * Given an array of n distinct integers. The task is to check whether reversing
     * any one sub-array can make the array sorted or not. If the array is already
     * sorted or can be made sorted by reversing any one subarray, print “Yes“, else
     * print “No“.
     * 
     * Examples:
     * 
     * 
     * Input : arr [] = {1, 2, 5, 4, 3}
     * Output : Yes
     * By reversing the subarray {5, 4, 3}, the array will be sorted.
     * 
     * Input : arr [] = { 1, 2, 4, 5, 3 }
     * Output : No
     * https://www.geeksforgeeks.org/check-reversing-sub-array-make-array-sorted/
     * 
     */
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 5, 3 };
        int[] arr2 = { 1, 2, 5, 4, 3 };
        System.out.println(isPossible(arr1));
        System.out.println(isPossible(arr2));
    }

    public static boolean isPossible(int[] arr) {
        int x = -1, y = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (x == -1) {
                    x = i;
                }
                y = i + 1;
            }
        }
        if (x != -1) {

            reverse(arr, x, y);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void reverse(int[] arr, int x, int y) {
        while (x < y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }
}
