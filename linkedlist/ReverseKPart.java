package linkedlist;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class ReverseKPart {
    /*
     * Approach:
     * 1. Split the linked list into groups of k nodes
     * - Use a list to store heads of each group
     * - Keep track of last incomplete group separately
     * 
     * 2. For each complete group (size k):
     * - Store the head node
     * - Break the connection to next group
     * - Add to list of groups
     * 
     * 3. Process each group:
     * - Reverse each complete group using stack
     * - Connect reversed groups together
     * - Maintain reference to last tail for connections
     * - First group becomes new head
     * 
     * 4. Finally:
     * - Connect last tail to any remaining incomplete group
     * - Return new head of modified list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - for stack and list storage
     * https://leetcode.com/problems/reverse-nodes-in-k-group/
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        // this list will contain heads of k-size ll
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head, lastHead = null;
        int count = 0;
        while (curr != null) {
            count = 0;
            lastHead = curr; // will track of last ll's head , if k-sized ll is not found -> this will contain head of last short ll
            ListNode prev = curr; // at the end of second loop , this will have last node of current ll
            while (curr != null && count < k) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            if (count == k) {
                // when k - sized ll is present
                prev.next = null; // break connection of this ll
                list.add(lastHead); // add its head in list
                lastHead = null; // update lastHead =null for next ll
            }
        }

        // reverse and connect ll
        ListNode lastTail = head; // this contains last node of previous ll
        ListNode firstHead = head; // this is new head
        for (int i = 0; i < list.size(); i++) {
            // reverse ll from list
            ListNode h = reverseList(list.get(i)), curr2 = h;
            if (i != 0) {
                // connect last ll's tail to this ll's head
                lastTail.next = h;
            } else {
                // get new head
                firstHead = h;
            }
            // loop to find end of a ll
            while (curr2.next != null) {
                curr2 = curr2.next;
            }
            // update lastTail
            lastTail = curr2;
        }
        // at the end if any short ll was present, set its head to lastTail 
        lastTail.next = lastHead;
        // return new head
        return firstHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        ListNode newHead = new ListNode(0);
        curr = newHead;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return newHead.next;
    }
}
