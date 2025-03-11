/**
 * This method finds a peak element in an array. A peak element is an element that is greater than its neighbors.
 * The method uses a binary search approach to find the peak element in O(log n) time complexity.
 *
 * Approach:
 * 1. Initialize two pointers, `s` (start) and `e` (end), to the beginning and end of the array respectively.
 * 2. Perform a binary search:
 *    a. Calculate the middle index `m` as `s + (e - s) / 2`.
 *    b. If the element at index `m` is greater than the element at index `m + 1`, it means the peak is in the left half (including `m`), so move the end pointer `e` to `m`.
 *    c. Otherwise, the peak is in the right half (excluding `m`), so move the start pointer `s` to `m + 1`.
 * 3. When the start pointer `s` equals the end pointer `e`, the peak element is found at index `s`.
 *
 * https://leetcode.com/problems/find-peak-element/
 */
package array.searching;

// approach
// 

public class FindPeakElement {
    public static void main(String[] args) {

    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (nums[m] > nums[m + 1]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}
