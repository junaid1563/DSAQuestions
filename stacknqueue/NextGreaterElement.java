package stacknqueue;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 3 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] ans = nextGreaterElement(nums1, nums2);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // final ans array
        int[] ans = new int[nums1.length];
        // stack to hold nums2 values
        Stack<Integer> s1 = new Stack<>();
        // fill nums2 values in s1
        for (int j : nums2) {
            s1.push(j);
        }

        // now loop on nums1
        for (int i = 0; i < nums1.length; i++) {
            int current = nums1[i];
            int next = -1;
            // stack to hold removed values of stack s1
            Stack<Integer> s2 = new Stack<>();
            while (!s1.isEmpty() && s1.peek() != current) {
                // pop from s1 until we get current element or s1 is empty
                int cs = s1.pop();
                if (cs > current) {
                    // if s1's element is greater than current, then update next
                    next = cs;
                }
                // push cs in s2 to later restock s1
                s2.push(cs);
            }
            // update ans array
            ans[i] = next;
            // restaock s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return ans;
    }
}
