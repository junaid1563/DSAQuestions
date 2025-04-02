/**
 * Solution for LeetCode 1209: Remove All Adjacent Duplicates in String II
 * 
 * Approach:
 * The solution uses a Stack data structure to track characters and their consecutive counts:
 * 1. Create a stack that stores String arrays where:
 *    - First element [0] stores the character
 *    - Second element [1] stores the count of consecutive occurrences
 * 
 * 2. For each character in the input string:
 *    - If stack is not empty and current char matches top of stack:
 *      > Increment the count of consecutive occurrences
 *    - Otherwise:
 *      > Push new char with count 1
 *    - If count reaches k:
 *      > Remove k elements from stack
 * 
 * 3. Finally, build result string:
 *    - Pop all elements from stack and append to StringBuilder
 *    - Reverse the result as stack gives characters in reverse order
 * 
 * Time Complexity: O(n) where n is length of input string
 * Space Complexity: O(n) for stack storage
 * 
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
 */
package stacknqueue;

import java.util.Stack;



public class RemoveAdjacentDups2 {
    public String removeDuplicates(String s, int k) {
        Stack<String[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && (ch + "").equals(stack.peek()[0])) {
                int current = Integer.parseInt(stack.peek()[1]);

                stack.push(new String[] { ch + "", (current + 1) + "" });
            } else {
                stack.push(new String[] { ch + "", "1" });
            }
            if (Integer.parseInt(stack.peek()[1]) == k) {
                int count = k;
                while (count > 0) {
                    stack.pop();
                    count--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()[0] + "");
        }

        return sb.reverse().toString();
    }
}
