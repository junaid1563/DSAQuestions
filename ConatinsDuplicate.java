import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// set is much faster than map

public class ConatinsDuplicate {
    public static void main(String[] args) {
        int []arr = {2,1,3,4,0,5,6,7,1};
        System.out.println(containsDuplicateMap(arr));
        System.out.println(containsDuplicateSet(arr));
    }

    public static boolean containsDuplicateMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(nums[i])) {
                return true;
            }
            map.put(i, nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicateSet(int[] nums) {
        Set<Integer> map = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                return true;
            }
            map.add(nums[i]);
        }
        return false;
    }
}
