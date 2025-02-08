package array;
// https://leetcode.com/problems/find-the-duplicate-number/
// Mpt solved yet

public class OneDuplicateInArray {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int maxSum = n * (n + 1) / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println("sum= " + sum);
        System.out.println("max sum= " + maxSum);
        if (maxSum != sum) {
            return maxSum - sum - 1;
        }
        return -1;
    }

}
