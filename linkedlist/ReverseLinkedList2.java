package linkedlist;

import java.util.Stack;

/**
 * Reverses a portion of a linked list from the given left index to the right index.
 *
 * @param head  The head of the linked list.
 * @param left  The starting index of the portion to be reversed (1-based index).
 * @param right The ending index of the portion to be reversed (1-based index).
 * @return The head of the modified linked list with the specified portion reversed.
 *
 * Approach:
 * 1. If left is equal to right, return the head as no reversal is needed.
 * 2. Initialize pointers: curr to head, prev to null, and next to head.
 * 3. Traverse the list to find the start node and the node before the start node (prev).
 * 4. Use a stack to store nodes from the left index to the right index.
 * 5. Disconnect the nodes from the left to right index from the rest of the list.
 *    - If left is 1, set head to null.
 *    - Otherwise, set prev.next to start.
 * 6. Reconnect the nodes in reverse order by popping from the stack and linking them.
 * 7. Connect the last reversed node to the node at the right+1 index.
 * 8. Return the modified head of the linked list.
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode curr = head, prev = null, next = head;
        ListNode start = head;
        // find start node and prev node
        for (int i = 1; i < left; i++) {
            prev = start;
            start = start.next;

        }
        int count = left;
        Stack<ListNode> stack = new Stack<>();

        // add nodes in stack from left to right index
        while (count <= right) {

            stack.push(start);
            start = start.next;
            count++;
        }
        // now disconnect nodes(left-> right) from other rows
        if (left == 1) {
            head = null;
        } else {
            prev.next = start;
        }

        next = start;
        curr = prev;
        // now connect those nodes again
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (head == null) {
                head = node;
                curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
        }
        // in the end connect last reversed node to right+1 index node
        curr.next = next;
        return head;
    }

}