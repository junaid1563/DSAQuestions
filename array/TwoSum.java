package array;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4 };
        int[] ans = twoSum(arr, 6);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = set.indexOf(target - nums[i]);
            if (set.contains(target - nums[i]) && j != i) {
                return new int[] { i, set.indexOf(target - nums[i]) };
            }
            set.add(nums[i]);
        }

        return new int[2];
    }
}
