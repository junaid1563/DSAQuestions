package array;

import java.util.ArrayList;
import java.util.List;

public class Array4Sum {
    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        System.out.println(fourSum(arr, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                int sum = nums[i] + nums[j];
                int lo = j + 1, hi = nums.length - 1;
                List<List<Integer>> twoSum = twoSum(nums, lo, hi, target - sum);
                System.out.println("Two sum = " + twoSum.toString());
                for (List<Integer> list : twoSum) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                }
                ans.addAll(twoSum);
            }
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] nums, int lo, int hi, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[lo]);
                list.add(nums[hi]);
                System.out.println(list);
                if (!ans.contains(list)) {
                    ans.add(list);
                }
                lo++;
                hi--;
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return ans;
    }
}
