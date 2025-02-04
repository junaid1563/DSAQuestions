package array;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
/*
 * Approach
 * maintain set to for repeated chars
 * also keep track of adjacent duplicates
 * in case of adjacent dupe -> reset substr and set, and move i to initial position + 1
 * in case of repeated char, no need to move i, just reset substr and set, add ith char in both and skip
*/
public class LongestSubstring {
    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        String sub = "";
        Set<Character> set = new HashSet<>();
        int ans = -1;
        int max = Integer.MIN_VALUE;
        char firstChar = s.charAt(0);
        set.add(firstChar);
        sub += firstChar;
        ans = sub.length();
        max = ans;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.charAt(i) == s.charAt(i - 1)) {
                sub = ch + "";
                ans = sub.length();
                set = new HashSet<>();
                set.add(ch);
                System.out.println("sub = " + sub);
                continue;
            }
            if (set.contains(ch)) {
                int lastIndex = i - sub.length();
                i = lastIndex;
                sub = "";
                ans = 0;
                set = new HashSet<>();
                System.out.println("sub = " + sub);
                continue;
            }
            sub += ch;
            System.out.println("ch =" + ch);
            set.add(ch);
            ans = sub.length();
            if (ans > max) {
                max = ans;
            }
            System.out.println("sub = " + sub);
        }
        return max;
    }
}
