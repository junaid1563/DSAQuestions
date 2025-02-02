import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * not optimized
*/
public class Array3Sum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = threeSum(arr);
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
}