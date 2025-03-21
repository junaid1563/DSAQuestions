package linkedlist;

/**
 * Removes the nth node from the end of a linked list.
 * 
 * Approach:
 * 1. First find the length of the linked list by traversing it once
 * 2. If n equals the length, we need to remove the head node - return head.next
 * 3. Otherwise, traverse to (length-n)th node from beginning:
 *    - Keep track of previous node while traversing
 *    - Move (length-n) steps forward from head
 * 4. Skip the nth node from end by updating prev.next to curr.next
 * 5. Return the head of modified list
 * 
 * Time Complexity: O(N) where N is the length of linked list
 * Space Complexity: O(1) as only constant extra space is used
 *
 * @param head Head node of the linked list
 * @param n Position from end to remove (1-based indexing)
 * @return Head of the modified linked list
 */
public class RemoveNthFromLast {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = len(head);
        if (n == len) {
            head = head.next;
            return head;
        }

        // remove len-n+1 element from front
        ListNode curr = head, prev = null;
        for (int i = 0; i < len - n; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
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
