
public class Main {
    public static void main(String[] args) {
        String str = "bbbb";
        System.out.println(largestSubString(str));
    }

    public static int largestSubString(String s) {
        String sub = "";
        int maxLength = 1;
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            sub = s.charAt(i) + "";
            for (int j = i + 1; j < s.length(); j++) {
                char b = s.charAt(j);
                // System.out.println(s.indexOf(b));
                if (!(sub.indexOf(b) > -1)) {
                    // System.out.println("Char added");
                    sub += b;
                    System.out.println(sub);
                    if (sub.length() > maxLength) {

                        maxLength = sub.length();
                    }
                } else {
                    sub = s.charAt(i) + "";
                    break;
                }

            }
        }
        return maxLength;
    }

    public static boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;
        while (i < j) {
            System.out.println("i=" + i + " j=" + j);
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if (!Character.isLetterOrDigit(ch1)) {
                i++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                j--;
            } else {
                if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public String reverse(String str) {
        int j = str.length() - 1;
        String ans = "";
        for (int i = j; i >= 0; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }
}