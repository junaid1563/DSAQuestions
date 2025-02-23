package strings;

import java.util.Stack;

/*Approach
 * 1. Split the input string by "/".
 * 2.Loop through all elements, if element is "." then continue, if element is ".." then pop the last element from stack.
 * 3. If element is not "." or ".." then push the element to stack.
 * 4. If stack is empty then return "/" else loop through stack and append all elements to string builder.
 * 5. Return the string builder.
 * https://leetcode.com/problems/simplify-path/
*/
public class SimplifyPath {
    public static void main(String[] args) {
        // Your code here
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

    public static String simplifyPath(String path) {
        String[] strs = path.split("/+");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            // System.out.println(str + "-" + str.length());
            if (str.length() > 0) {
                if (str.equals(".")) {
                    continue;
                } else if (str.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(str);
                }
            }
        }

        if (stack.isEmpty()) {
            sb.append("/");
        } else {
            for (int i = 0; i < stack.size(); i++) {
                sb.append("/" + stack.get(i));
            }
        }

        return sb.toString();
    }
}