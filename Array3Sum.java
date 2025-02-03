import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * not optimized
*/
public class Array3Sum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = threeSum2(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // first element in i
            for (int j = 0; j != i && j < nums.length; j++) {
                // second element in j
                int k = map.get(-(nums[i] + nums[j])) == null ? -1 : map.get(-(nums[i] + nums[j]));
                // third element in k
                if (k > 0 && k != i && k != j) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-(nums[j] + nums[i]));
                    list.sort(null);
                    if (ans.size() == 0) {
                        ans.add(list);
                        break;
                    }
                    boolean foundList = false;
                    for (int m = 0; m < ans.size(); m++) {
                        List<Integer> mainList = ans.get(m);
                        mainList.sort(null);
                        if (mainList.equals(list)) {
                            foundList = true;
                            break;
                        }
                    }
                    if (!foundList) {
                        ans.add(list);
                    }

                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        // first sort array
        Arrays.sort(nums);
        // final ans list
        List<List<Integer>> ans = new ArrayList<>();
        // loop through array
        for (int i = 0; i < nums.length; i++) {
            // lo and hi pointer for rest of array, to find two sum lists
            int lo = i + 1, hi = nums.length - 1;
            // if we find dupicate for first element,we skip it
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // target sum for two sum
            int target = -nums[i];
            List<List<Integer>> twoSum = twoSum(nums, lo, hi, target);
            // loop through answers and add all lists in final answer
            for (List<Integer> list : twoSum) {
                list.add(nums[i]);
            }
            ans.addAll(twoSum);
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] arr, int lo, int hi, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == target) {
                // find two sum
                List<Integer> list = new ArrayList<>();
                list.add(arr[lo]);
                list.add(arr[hi]);
                if (!ans.contains(list)) {
                    ans.add(list);
                }
                lo++;
                hi--;
            } else if (sum > target) {
                // when sum is big, we need to decrease sum, so move left -> hi--
                hi--;
            } else {
                // when sum is smaller, we need to increase it,so move right -> lo++
                lo++;
            }
        }
        return ans;
    }
}