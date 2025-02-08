package array;
public class SortColors {
    // https://leetcode.com/problems/sort-colors/
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 1, 0, 0, 1, 1, 0 };
        sortColors(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sortColors(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

    }
}