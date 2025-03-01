package maths;

// adding two binary strings bit by bit
// https://leetcode.com/problems/add-binary/
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "111111"));
    }

    public static String addBinary(String a, String b) {

        if (a.length() < b.length()) {
            while (a.length() != b.length()) {
                String newStr = 0 + "" + a;
                a = newStr;
            }
        }
        if (b.length() < a.length()) {
            while (a.length() != b.length()) {
                String newStr = 0 + "" + b;
                b = newStr;
            }
        }
        System.out.println(a + " " + b);
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int rem = 0;
        while (i >= 0 && j >= 0) {
            int n1 = Integer.parseInt(a.charAt(i) + "");
            int n2 = Integer.parseInt(b.charAt(j) + "");

            sb.append((n1 ^ n2 ^ rem) + "");
            if ((n1 == 1 && n2 == 1) || ((n1 ^ n2) == 1 && rem == 1)) {
                rem = 1;
            } else {
                rem = 0;
            }
            i--;
            j--;
        }
        if (rem == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
