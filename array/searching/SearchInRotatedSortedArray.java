/**
 * This class provides a method to search for a target value in a rotated sorted array.
 * A rotated sorted array is an array that has been sorted and then rotated some number of times.
 * 
 * Approach:
 * 1. Initialize two pointers, `s` (start) and `e` (end), to the beginning and end of the array respectively.
 * 2. Use a binary search approach to find the target value:
 *    - Calculate the middle index `m`.
 *    - If the middle element `nums[m]` is equal to the target, return the middle index.
 *    - Determine which part of the array is sorted:
 *      - If the left part `nums[s]` to `nums[m]` is sorted:
 *        - Check if the target is within this range:
 *          - If yes, move the end pointer `e` to `m - 1`.
 *          - If no, move the start pointer `s` to `m + 1`.
 *      - If the right part `nums[m]` to `nums[e]` is sorted:
 *        - Check if the target is within this range:
 *          - If yes, move the start pointer `s` to `m + 1`.
 *          - If no, move the end pointer `e` to `m - 1`.
 * 3. Repeat the process until the target is found or the pointers cross each other.
 * 4. If the target is not found, return -1.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * The time complexity of this approach is O(log n) due to the binary search mechanism.
 * The space complexity is O(1) as no additional space is used.
 */
package array.searching;
// 
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 4,5,6,7,0,1,2};
        int target = 4;
        System.out.println(search(nums, target)); // 4
    }

    public static int search(int[] nums, int target) {
        int n = nums.length, s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            System.out.println("s: " + s + " e: " + e + " m: " + m);
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] >= nums[s]) {
                System.out.println("left array is sorted");
                // checking if left array is sorted
                if (target >= nums[s] && target < nums[m]) {
                  // target exists in left array
                  System.out.println("target exists in left array");
                    e = m - 1;
                } else {
                    // target does not exists in left array
                    System.out.println("target does not exists in left array");
                    s = m + 1;
                }
            } else {
                System.out.println("right array is sorted");
                if (target > nums[m] && target <= nums[e]) {
                    System.out.println("target exists in right array");
                    s = m + 1;
                } else {
                    System.out.println("target does not exists in right array");
                    e = m - 1;
                }
            }

        }
        return -1;
    }
}
