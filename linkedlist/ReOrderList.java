package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Reorders a singly linked list in-place from L0 → L1 → ... → Ln to L0 → Ln →
 * L1 → Ln-1 → L2 → Ln-2 → ...
 * 
 * Approach:
 * 1. Find the length and middle point of the linked list
 * 2. Store the left half of the list (from start to middle) in an ArrayList
 * queue
 * 3. Store the right half of the list (from middle+1 to end) in a Stack
 * 4. Create a new dummy head node for result construction
 * 5. Alternate between:
 * - Taking nodes from queue (left half in original order)
 * - Taking nodes from stack (right half in reversed order)
 * 6. Connect nodes in the new required order
 * 7. Set the last node's next pointer to null to avoid cycles
 *
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 * Space Complexity: O(n) for storing nodes in ArrayList and Stack
 *
 * @param head The head node of the input linked list
 */
public class ReOrderList {
    public void reorderList(ListNode head) {
        System.out.println(len(head));
        int mid = len(head) / 2;
        ListNode curr = head;
        ArrayList<ListNode> queue = new ArrayList<>();
        // adding in queue(left half)
        for (int i = 1; i <= mid; i++) {
            queue.add(curr);
            curr = curr.next;
        }

        Stack<ListNode> stack = new Stack<>();
        // pushing right half in stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int count = 0;
        ListNode newHead = new ListNode(0);
        curr = newHead;
        while (count < queue.size()) {
            ListNode qnode = queue.get(count);
            ListNode snode = stack.pop();
            qnode.next = snode;
            curr.next = qnode;
            curr = snode;
            count++;
        }

        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        // detech last node from previous pointer
        curr.next = null;

        head = newHead.next;
    }

    public int len(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
