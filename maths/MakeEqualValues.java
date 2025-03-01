package maths;

public class MakeEqualValues {
    // When all elements will be equal, sum will be x*n
    // we can find x, by minNum, at the end minNum will be increased by m
    // m is total number of steps
    // final_sum = n*x = n*(minNum+m)
    // initial sum = sum
    // final_sum = sum + m*(n-1)
    // so finally m = sum - n* minNum
    // https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
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
