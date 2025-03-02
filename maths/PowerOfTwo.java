package maths;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(20));
        System.out.println(isPowerOfTwo2(20));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return n % 2 == 0 && isPowerOfTwo(n / 2);
    }

    public static boolean isPowerOfTwo2(int n) {
        // 2's power will always have 1 1-bit
        // ex: 2=0010, 4 = 0100, 8=1000 etc
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
