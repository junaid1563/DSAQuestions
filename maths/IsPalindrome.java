package maths;

public class IsPalindrome {
    // https://leetcode.com/problems/palindrome-number/
    // Approach 1 - convert to string and verify if string is palindrome
    // Approach 2 - find reverse number and compare with original number
    public static void main(String[] args) {
        System.out.println(isPalindrome2(12121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        int i = 0, j = str.length() - 1;
        while (i < j) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            if (ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int findDigits(int n) {
        int dig = 0, num = n;
        while (num != 0) {
            dig++;
            num /= 10;
        }
        return dig;
    }

    public static boolean isPalindrome2(int n) {
        int reverse = 0, num = n;
        while (num != 0) {
            int digits = findDigits(num);
            reverse += (num % 10) * Math.pow(10, digits - 1);
            num /= 10;
        }
        if (n == reverse) {
            return true;
        }
        return false;
    }
}
