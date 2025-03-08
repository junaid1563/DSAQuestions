package array.searching;

import java.util.Arrays;

public class PairDifference {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(findPair(arr, 0));
    }

    public static boolean findPair(int[] arr, int x) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        int i = 0, j = n - 1;
        while (i < j) {
            int diff = Math.abs(arr[i] - arr[j]);
            System.out.println(diff);
            if (diff == x) {
                return true;
            } else if (diff < x) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
