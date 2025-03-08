/**
 * This class implements the Counting Sort algorithm.
 * 
 * <p>Counting Sort is a non-comparative sorting algorithm that sorts integers
 * by counting the number of occurrences of each unique value in the array.
 * The algorithm works by creating a frequency array to count the occurrences
 * of each value, and then reconstructing the sorted array based on these counts.
 * 
 * <p>Approach:
 * <ol>
 *   <li>Find the maximum value in the input array to determine the size of the frequency array.</li>
 *   <li>Create a frequency array of size (max + 1) to store the count of each value.</li>
 *   <li>Iterate through the input array and update the frequency array with the count of each value.</li>
 *   <li>Reconstruct the sorted array by iterating through the frequency array and updating the original array with sorted values.</li>
 * </ol>
 * 
 * <p>Time Complexity: O(n + k), where n is the number of elements in the input array and k is the range of the input.
 * <p>Space Complexity: O(k), where k is the range of the input.
 * 
 * <p>Note: This implementation assumes that all elements in the input array are non-negative integers.
 */
package array.sorting;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = { 9, 1, 2, 36, 90 };
        countSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void countSort(int[] arr) {
        int max = findMax(arr);
        int[] freq = new int[max + 1];
        // frequency count
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]] += 1;
        }

        // now update original array again
        int c = 0;
        for (int i = 0; i < freq.length;) {
            if (freq[i] == 0) {
                i++;
                continue;
            }
            arr[c] = i;
            freq[i]--;
            c++;
        }
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
