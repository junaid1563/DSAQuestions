package linkedlist;

/**
 * Merges k sorted linked lists into a single sorted linked list.
 * 
 * Approach:
 * 1. Handle base cases:
 * - If array is empty, return null
 * - If array has single list, return that list
 * 2. Take first list as initial merged list
 * 3. Iteratively merge each remaining list with current merged list:
 * - Compare nodes from both lists and create new merged list
 * - At each step, pick smaller value node
 * - Advance pointer in list from which node was picked
 * 
 * Time Complexity: O(N * K) where N is total number of nodes across all lists
 * and K is number of lists
 * Space Complexity: O(1) as only constant extra space is used
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 * @param lists Array of sorted linked list heads to be merged
 * @return Head of the merged sorted linked list
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {

            head = merge(head, lists[i]);
        }
        return head;
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead, c1 = h1, c2 = h2;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                curr.next = c1;
                if (c1.next == null) {
                    c1 = null;
                } else {

                    c1 = c1.next;
                }
            } else {
                curr.next = c2;
                if (c2.next == null) {
                    c2 = null;
                } else {

                    c2 = c2.next;
                }
            }
            curr = curr.next;
        }
        curr.next = c1 != null ? c1 : c2;
        return newHead.next;
    }
}
