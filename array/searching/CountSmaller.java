
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountSmaller {
    public static void main(String[] args) {
        int[] arr = { 26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94,
                13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41 };
        System.out.println(countSmaller(arr));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, 0);
        for (int i = 1; i < n; i++) {
            for (Entry entry : map.entrySet()) {
                // compare existing values in map
                if (nums[i] <= nums[(int) entry.getKey()]) {
                    map.replace((Integer) entry.getKey(), (Integer) entry.getValue() + 1);
                }
            }
            if (!map.containsKey(i)) {

                map.put(i, 0);
            }
        }

        System.out.println("map in last " + map.toString());
        for (int i = 0; i < nums.length; i++) {
            ans.add(map.get(    i));
        }
        return ans;
    }
}