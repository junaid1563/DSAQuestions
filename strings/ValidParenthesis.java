package strings;

import java.util.Stack;
// https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "()[]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                // opening bracket found
                stack.push(ch);
            } else {
                // closing bracket found
                if (stack.size() == 0) {
                    // no opening bracket in stack
                    return false;
                }
                char top = stack.pop();
                if ((top == '(' && ch != ')') || (top == '[' && ch != ']') || (top == '{' && ch != '}')) {
                    // opening an closing brackets are not matching
                    return false;
                }

            }
        }
        if(stack.size()>0){
            // more opening brackets than closing
            return false;
        }

        return true;
    }
}
