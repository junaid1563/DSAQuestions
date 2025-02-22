package strings;
public class LongestCommonPrefix {

    // Longest Common Prefix: https://leetcode.com/problems/longest-common-prefix/
    /*
     * bruteforce approach
     * compare two adjacent strings, find their common prefix
     * then find common prefix between final common prefix and current common prefix
    */
    public static void main(String[] args) {
        // String[] arr = { "flow", "flower", "flight" };
        String[] arr = { "cir", "car" };
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String longest_common = "";
        for (int i = 0; i < strs.length - 1; i++) {
            String common = commonPrefix(strs[i], strs[i + 1]);
            if (common.length() == 0) {
                return "";
            }
            System.out.println("common = " + common + ", longest = " + longest_common);
            if (longest_common.length() > 0) {
                longest_common = commonPrefix(longest_common, common);
            } else {
                longest_common = common;
            }

        }
        return longest_common;
    }

    public static String commonPrefix(String str1, String str2) {
        int i = 0, j = 0;
        String common = "";
        while (i < str1.length() && j < str2.length()) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if (ch1 == ch2) {
                common += ch1;
            } else {
                break;
            }
            i++;
            j++;
        }
        return common;
    }
}
