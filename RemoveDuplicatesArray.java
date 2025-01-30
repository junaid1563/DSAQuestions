public class RemoveDuplicatesArray {
    /*
     * we compare i and i+1 elements, if they are not same then we swap ith and idx
     * elements
     * also increase idx
     * Remove Duplicates from Sorted Array: https://leetcode.com/problems/remove-
     * duplicates-from-sorted-array/
     */
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 3, 4, 5, 5, 6, 7 };
        System.out.println(removeDuplicates(arr));
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int idx = 0;
        int length = nums.length;
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;

                idx++;
            } else {
                length--;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = tmp;

        return length;
    }
}