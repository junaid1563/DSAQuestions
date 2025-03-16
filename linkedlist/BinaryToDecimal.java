package linkedlist;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class BinaryToDecimal {

    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        // in this approach we convert binary to decimal , digit by digit
        // instead of converting whole number at once by division method
        // why?
        // because here we are traversing number left to right, but genrally we have to
        // traverse right to left by using remainder
        int decimal = 0;
        ListNode curr = head;
        while (curr != null) {
            decimal = decimal * 2 + curr.val;
            curr = curr.next;
        }
        // System.out.println(decimal);
        return decimal;
    }

    public static int convert(int num, int cBase, int nBase) {
        int ans = 0;
        int n = num;
        int mul = 1;
        while (n != 0) {
            int rem = n % nBase;
            ans += rem * mul;
            n = n / nBase;
            mul *= cBase;
        }
        return ans;
    }
}
