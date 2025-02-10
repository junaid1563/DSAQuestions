package array;

import java.util.ArrayList;
import java.util.List;

/*
 * Approach
 * We can modify existing array, such that we make nums[idx] negative on each oteation
 * then if we find -ve value somewhere, it means it is a duplicate 
 * so we add idx=1 in list
 * 
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
*/
public class FindAllDuplicatesArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 2, 5, 3, 3 };
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < nums.length; i++) {
        // if (set.contains(nums[i])) {
        // list.add(nums[i]);
        // } else {F
        // set.add(nums[i]);
        // }

        // }
        // return list;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                list.add(idx + 1);
            }
            nums[idx] = -nums[idx];
        }
        return list;
    }
}
