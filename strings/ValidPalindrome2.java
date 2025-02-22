package strings;
// https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindrome2 {
    public static void main(String[] args) {
        String str = "abcka";
        System.out.println(validPalindrome(str));
    }

    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1, skip = 0;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2) {
                // when we found first unmatched chars
                // now check after removing them, are we getting palidrome or not
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
