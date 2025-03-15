
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountSmaller {
    public static void main(String[] args) {
        int[] arr =
                // { 5, 2, 1, 6 };
                { 26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98,
                        69, 81, 32, 78, 28, 94,
                        13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41 };
        System.out.println(count(arr));
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
            ans.add(map.get(i));
        }
        return ans;
    }

    public static List<Integer> count(int[] arr) {
        int[] ans = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, ans);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            list.add(ans[i]);
        }
        return list;
    }

    public static void mergeSort(int[] arr, int left, int right, int[] ans) {
        if (left >= right) {
            return;
        }

        System.out.println("Inside mergeSort");
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, ans);
        mergeSort(arr, mid + 1, right, ans);
        merge(arr, left, mid, right, ans);

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] ans) {
        int l1 = left, l2 = mid + 1, r1 = mid, r2 = right;
        int i = l1;
        System.out.println("inside merge");
        while (i <= r1) {
            System.out.println(i);
            int j = l2;
            while (j <= r2) {
                if (arr[j] < arr[i]) {
                    ans[i]++;
                }
                j++;
            }
            i++;
        }

    }
}
