/**
 * Removes all elements from the linked list that have the specified value.
 *
 * Approach:
 * 1. Check if the head is null. If it is, return null as there are no elements to remove.
 * 2. Iterate through the list to remove any leading nodes that have the value `val`.
 * 3. Use two pointers, `prev` and `curr`, to traverse the list:
 *    - `prev` points to the previous node.
 *    - `curr` points to the current node.
 * 4. For each node, check if `curr.val` is equal to `val`:
 *    - If it is, adjust the `next` pointer of `prev` to skip the current node.
 *    - Move `curr` to the next node.
 * 5. Continue this process until all nodes with the value `val` are removed.
 * 6. Finally, check if the head itself needs to be removed and adjust accordingly.
 *
*   https://leetcode.com/problems/remove-linked-list-elements/
 */
package linkedlist;

public class RemoveVal {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // check if head is val
        // run loop becuase it can have duplicates
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = head;
        while (curr != null && curr.next != null) {
            // maintain prev and curr
            prev = curr;
            curr = curr.next;
            // check if curr.val==val
            if (curr.val == val) {
                prev.next = curr.next;
                curr = prev;
            }
        }
        if (curr != null && curr == head && curr.val == val) {
            head = null;
        }
        return head;
    }

}