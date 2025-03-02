package maths;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 ,0};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0, i = 0;
        while (i < nums.length) {
            sum += nums[i];
            i++;
        }
        int n = nums.length, actual_sum = n * (n + 1) / 2;
        return actual_sum - sum;
    }
}
