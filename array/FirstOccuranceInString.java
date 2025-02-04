package array;
public class FirstOccuranceInString {
    public static void main(String[] args) {
        String str = "ABCDcarandAcar";
        String sub = "car";
        System.out.println(strStr(str, sub));
    }

    //  not completed yet
    public static int strStr(String haystack, String needle) {
        int ans = -1, hay = 0, nee = 0;
        boolean found = false;
        int firstHay = -1;
        while (hay < haystack.length()) {
            if (haystack.charAt(hay) == needle.charAt(nee)) {
                if (nee == 0) {
                    firstHay = hay;
                }
                nee++;
                if (nee == needle.length()) {
                    ans++;
                    found = true;
                    return ans;
                }
            } else {
                ans = hay;
                nee = 0;
                hay = firstHay++;
                firstHay = -1;
            }
            hay++;
        }
        if (!found) {
            return -1;
        }
        return ans;
    }
}
