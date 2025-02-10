package array;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 0, -2, -3, 1 };

        System.out.println(subarraysDivByK(arr, 5));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum % k == 0) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
