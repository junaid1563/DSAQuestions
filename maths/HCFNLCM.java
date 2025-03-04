package maths;

public class HCFNLCM {
    public static void main(String[] args) {
        System.out.println(hcf(22, 3));
        System.out.println(lcm(22, 3));
    }

    public static int hcf(int a, int b) {
        if (a == 0) {
            return b;
        }
        return hcf(b % a, a);
    }

    public static int lcm(int a, int b) {
        return (a * b) / hcf(a, b);
    }
}
