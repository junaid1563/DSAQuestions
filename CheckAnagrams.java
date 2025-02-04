import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckAnagrams {
    public static void main(String[] args) {
        String[] strs = { "bat", "cat", "tac", "eat", "ate", "tea" };
        String[] strs2 = { "ddddddddddg", "dgggggggggg" };
        System.out.println(groupAnagrams(strs2));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> checked = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (checkAnagram(strs[i], strs[j])) {
                    if (!checked.contains(j)) {

                        if (list.size() == 0) {
                            list.add(strs[i]);
                            checked.add(i);
                        }
                        list.add(strs[j]);
                        checked.add(j);
                    }
                }
            }
            if (!checked.contains(i)) {
                list.add(strs[i]);
                checked.add(i);
            }
            if (list.size() > 0) {
                ans.add(list);
            }

        }
        return ans;
    }

    public static boolean checkAnagram(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }
        if (str1.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] c1 = str1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = str2.toCharArray();
        Arrays.sort(c2);
        System.out.println(c1.toString() + " - " + c2.toString());
        if (Arrays.equals(c1, c2)) {
            return true;
        }
        return false;
    }
}
