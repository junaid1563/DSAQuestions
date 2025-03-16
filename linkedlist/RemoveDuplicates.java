package linkedlist;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,1,2]
 * Output: [1,2]
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * 
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        while (curr != null && curr.next != null) {
            prev = curr;
            curr = curr.next;
            if (prev.val == curr.val) {
                prev.next = curr.next;
                // set curr to prev, so that we can check if more duplicates exists
                curr = prev;
            }
        }
        return head;
    }
}
