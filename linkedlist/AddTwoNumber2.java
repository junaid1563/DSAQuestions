package linkedlist;

import java.util.Stack;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]

https://leetcode.com/problems/add-two-numbers-ii/description/

*/
public class AddTwoNumber2 {
    /**
     * This method adds two numbers represented by two linked lists.
     * The digits are stored in reverse order, and each of their nodes contains a
     * single digit.
     * The function returns the sum as a linked list.
     *
     * Approach:
     * 1. Reverse both input linked lists.
     * 2. Traverse both reversed linked lists and add corresponding digits.
     * 3. If the sum of two digits is greater than or equal to 10, set carry to 1
     * and reduce the sum by 10.
     * 4. Create a new node with the sum and attach it to the result linked list.
     * 5. Continue the process until both linked lists are fully traversed.
     * 6. If there is a carry left after the final addition, create a new node with
     * the carry.
     * 7. Reverse the result linked list to restore the original order.
     *
     * @param l1 the first linked list
     * @param l2 the second linked list
     * @return the sum as a linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverse(l1), h2 = reverse(l2), c1 = h1, c2 = h2;
        ListNode head = new ListNode(0), curr = head;
        int carry = 0;
        while (c1 != null && c2 != null) {
            int sum = c1.val + carry + c2.val;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            curr.next = node;
            curr = curr.next;

            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            int sum = c1.val + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            curr.next = node;
            curr = curr.next;
            if (c1.next == null) {
                c1 = null;
                break;
            }
            c1 = c1.next;
        }
        while (c2 != null) {
            int sum = c2.val + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            curr.next = node;
            curr = curr.next;
            if (c2.next == null) {
                c2 = null;
                break;
            }
            c2 = c2.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            curr.next = node;
            curr = curr.next;
        }

        return reverse(head.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        ListNode newHead = new ListNode(0);
        curr = newHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            curr.next = node;
            curr = curr.next;
        }
        curr.next = null;
        return newHead.next;
    }
}
