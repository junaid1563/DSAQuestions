/**
 * This interface provides a method to find the intersection node of two singly linked lists.
 * 
 * <p>The method uses a HashSet to store the nodes of the first linked list and then checks 
 * if any node in the second linked list is already present in the HashSet, indicating the 
 * intersection point.</p>
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * 
 */
package linkedlist;

import java.util.HashSet;

public interface IntersectionOfLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet();
        ListNode h1 = headA, h2 = headB, curr = h1;
        while (curr != null) {
            set.add(curr);
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        curr = h2;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        return null;
    }
}
