package strings;

public class FirstOccuranceInString {
    public static void main(String[] args) {
        String str = "mississippi";
        String sub = "issipi";
        System.out.println(strStr(str, sub));
    }

    // we are running nested loops to check if both strings are same
    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
        
    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int j = i;
            int idx = j - i;
            while (idx < needle.length() && j < haystack.length() && haystack.charAt(j) == needle.charAt(idx)) {
                idx++;
                j++;
            }
            if (idx == needle.length()) {
                return i;
            }

        }
        return -1;
    }

}
