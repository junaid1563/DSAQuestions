package maths;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/happy-number/
// approach: if num is not happy number then sum will repeat itself after one time 
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        int sum = n;
        while (sum != 1) {
            int num = sum;
            sum = 0;
            while (num != 0) {
                sum += Math.pow((num % 10), 2);
                num = num / 10;
            }
            System.out.println("sum" + sum);
            if (list.contains(sum)) {
                return false;
            }

            list.add(sum);
        }
        return true;
    }
}
