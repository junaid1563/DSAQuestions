import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Approach
 * First seperate numbers ans signs
 * For this we go through string , keep two pointers, i and j, j keeps track of first index of current digit
 * as we find any non-digit characters, we add that char to characters list and take substring(j,i) fot digit and add in digit list.
 * 
 * Next we need to find order of operations, for this we use stack. If sign is + or -, we add current digit to stack, else we pop and 
 * calculate result between curretn digit and last pop value and add that to stack.
 * 
 * At the end we add all values of stack and find result.
 * 
 * https://leetcode.com/problems/basic-calculator-ii/
*/

public class BasicCalculator {
    public static void main(String[] args) {
        int ans = calculate(" 3+2*2-4*2 ");
        System.out.println(ans);
    }

    public static int calculate(String s) {
        String[] strs = s.split(" ");
        String str = "";
        for (String st : strs) {
            str += st;
        }
        s = str;
        List<Integer> digits = new ArrayList<>();
        List<Character> signs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                signs.add(s.charAt(i));
                digits.add(Integer.parseInt(s.substring(j, i)));
                j = i + 1;
            }
        }
        digits.add(Integer.parseInt(s.substring(j)));

        int ans = 0;
        // if(signs.get(0)=='+'){}
        stack.add(digits.get(0));
        // 3+2*2-4*2
        int d = 1, si = 0;
        while (d < digits.size() && si < signs.size()) {
            char sign = signs.get(si);
            int digit = digits.get(d);
            if (sign == '+') {
                // System.out.println("+" + digit);
                stack.push(digit);
            } else if (sign == '-') {
                // System.out.println("-" + digit);
                stack.push(-digit);
            } else if (sign == '*') {
                // System.out.println("*" + digit);
                int lastDigit = stack.pop();
                int newValue = lastDigit * digit;
                stack.push(newValue);
            } else if (sign == '/') {
                int lastDigit = stack.pop();
                int newValue = lastDigit / digit;
                stack.push(newValue);
            }
            d++;
            si++;
        }
        for (int i : stack) {
            // System.out.print(i + " ");
            ans += i;
        }
        return ans;
    }
}