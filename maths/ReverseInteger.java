package maths;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(23414));
    }

    public static int reverse(int x) {

        int num = x, reverse = 0;
        while (num != 0) {
            int digits = getDigits(num);
            reverse += (num % 10) * Math.pow(10, digits - 1);
            num /= 10;
        }
        if (reverse >= Integer.MAX_VALUE || reverse <= Integer.MIN_VALUE) {
            return 0;
        }
        return reverse;
    }

    public static int getDigits(int num) {
        int digs = 0, n = num;
        while (n != 0) {
            digs++;
            n /= 10;
        }
        return digs;
    }
}
