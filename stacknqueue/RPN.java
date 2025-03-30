package stacknqueue;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
/**
 * Evaluates a Reverse Polish Notation (RPN) expression
 * 
 * Approach:
 * 1. Use a stack to keep track of numbers
 * 2. Iterate through each token:
 *    - If token is a number, push to stack
 *    - If token is an operator, pop top 2 numbers from stack:
 *      * First pop is second operand
 *      * Second pop is first operand
 *    - Apply operator to numbers in correct order
 *    - Push result back to stack
 * 3. Stack will contain final result
 * 
 * Time Complexity: O(n) where n is number of tokens
 * Space Complexity: O(n) for stack storage
 * 
 *
 * Example:
 * Input: ["2","1","+","3","*"]
 * Stack operations:
 * - Push 2
 * - Push 1 
 * - Pop 1,2 -> Calculate 2+1=3 -> Push 3
 * - Push 3
 * - Pop 3,3 -> Calculate 3*3=9 -> Push 9
 * Output: 9
 */
public class RPN {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < tokens.length; i++) {
            // System.out.println(stack.toString());
            if (isNumber(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                String op = tokens[i];
                // System.out.println("num1 = "+num1+" op = "+op+" num2 = "+num2);
                int temp = 0;
                if (op.equals("+")) {
                    temp = num1 + num2;
                } else if (op.equals("-")) {
                    temp = num2 - num1;
                } else if (op.equals("*")) {
                    temp = num1 * num2;
                } else if (op.equals("/")) {
                    temp = num2 / num1;
                }
                // System.out.println("Temp = "+temp);
                stack.push(temp);
                ans = temp;
            }
        }
        return ans;
    }

    public boolean isNumber(String str) {

        switch (str) {
            case "+":
                return false;
            case "-":
                return false;
            case "/":
                return false;
            case "*":
                return false;
            default:
                return true;

        }

    }
}
