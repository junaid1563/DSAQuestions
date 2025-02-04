package array;
public class RotateArrayByK {
    // Rotate Array: https://leetcode.com/problems/rotate-array/ 
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 3);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int flo = 0, fhi = nums.length - k - 1, slo = fhi + 1, shi = nums.length - 1;
        // reverse first side array
        reverseArray(nums, flo, fhi);
        // reverse second side array
        reverseArray(nums, slo, shi);
        // everse whole array
        reverseArray(nums, flo, shi);
    }

    public static void reverseArray(int[] arr, int lo, int hi) {
        int i = lo, j = hi;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
