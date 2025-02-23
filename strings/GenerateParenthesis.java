package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Approach
/*
 * We first generate all possible sequences for a given n recursively. 
 * In base case we validate if genarted sequence is valid or not.
 * If it is valid then we add it in list.
 * https://leetcode.com/problems/generate-parentheses/
*/
public class GenerateParenthesis {
    public static void main(String[] args) {
        // You can test your methods here
        System.out.println(generateParenthesis(4));
    }

    // Method to generate parentheses will go here
    public static List<String> generateParenthesis(int n) {
        // List<String> result = new ArrayList<>();
        List<String> result = generate(2 * n, "");
        return result;
    }

    public static List<String> generate(int n, String str) {
        // this method will generate all possible sequences for a given n
        // but in base case we will validate if generated sequence is valid or not
        if (n == 0) {

            List<String> r = new ArrayList<>();
            if (isValidParenthesis(str)) {
                r.add(str);
            }
            return r;
        }

        List<String> l1 = generate(n - 1, str + "(");
        List<String> l2 = generate(n - 1, str + ")");
        l1.addAll(l2);
        return l1;
    }

    public static boolean isValidParenthesis(String str) {
        // to validate if given sequence is valid or not
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    // no opening bracket
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            // if some closing bracket are missing
            return false;
        }
        return true;
    }
}