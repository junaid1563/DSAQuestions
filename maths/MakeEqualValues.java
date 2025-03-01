package maths;

public class MakeEqualValues {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(minMoves(arr));
    }

    public static int minMoves(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int min = min(nums);
        return sum - nums.length * min;
    }

    public static int min(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];

            }
        }
        return min;
    }
}
