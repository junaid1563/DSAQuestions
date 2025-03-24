/**
 * Approach to compare two strings after applying backspace operations
 * 
 * The algorithm works as follows:
 * 1. Create two stacks to store characters from both strings
 * 2. For each string:
 *    - Iterate through each character
 *    - If current char is '#' and stack is not empty, pop from stack (backspace)
 *    - If current char is not '#', push it to stack
 * 3. Compare the resulting stacks:
 *    - First check if sizes are equal
 *    - Then compare each character by popping from both stacks
 * 
 * Time Complexity: O(M + N) where M and N are lengths of input strings
 * Space Complexity: O(M + N) to store the characters in stacks
 * https://leetcode.com/problems/backspace-string-compare/
 * @param s First string with backspace characters
 * @param t Second string with backspace characters
 * @return true if both strings are equal after applying backspaces, false otherwise
 */
package stacknqueue;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s1 = "ab#cd";
        String s2 = "b#acd";
        System.out.println(backspaceCompare(s1, s2));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (s1.isEmpty()) {
                    continue;
                }
                s1.pop();
            } else {
                s1.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (s2.isEmpty()) {
                    continue;
                }
                s2.pop();
            } else {
                s2.push(t.charAt(i));
            }
        }
        if (s1.size() != s2.size()) {
            return false;
        } else {
            while (!s1.isEmpty()) {
                if (s1.pop() != s2.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}
