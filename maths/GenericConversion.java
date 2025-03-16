package maths;

public class GenericConversion {
    public static void main(String[] args) {
        System.out.println(convert(32, 10, 2));
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
