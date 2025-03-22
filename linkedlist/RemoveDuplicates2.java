package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Removes duplicate elements from a sorted linked list, keeping only unique elements.
 * For example, given 1->2->2->3->3->4, returns 1->4
 * 
 * Approach:
 * 1. Traverse the linked list using two pointers - curr and next
 * 2. For each node:
 *    - Check if current value has duplicates by comparing with next nodes
 *    - If duplicates found, skip all nodes with same value
 *    - If no duplicates found, add value to result list
 * 3. Create new linked list from unique values stored in list
 *
 * Time Complexity: O(n) where n is number of nodes in input list
 * Space Complexity: O(n) to store unique values in ArrayList
 *https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * @param head The head node of the input linked list
 * @return Head node of the linked list with duplicates removed
 */
public class RemoveDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head, next = head;
        List<Integer> list = new ArrayList<>();

        while (next != null) {
            boolean dup = false;
            curr = next;
            next = next.next;
            while (next != null && curr.val == next.val) {
                dup = true;
                next = next.next;
            }
            curr.next = next;
            if (dup == false) {
                list.add(curr.val);
            }

        }
        ListNode nh = new ListNode(0);
        curr = nh;
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            curr.next = node;
            curr = curr.next;
        }

        return nh.next;
    }
}
