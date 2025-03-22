package linkedlist;
/**
 * Approach: Merge Sort for Linked List
 * 
 * 1. Base Case: If list is empty or has single node, return as is
 * 
 * 2. Find Middle:
 *    - Use slow and fast pointers (Floyd's algorithm)
 *    - Fast moves twice as fast as slow
 *    - When fast reaches end, slow is at middle
 * 
 * 3. Split List:
 *    - Break list into two halves at middle
 *    - First half: head to middle
 *    - Second half: middle+1 to end
 * 
 * 4. Recursive Sort:
 *    - Recursively sort both halves
 *    - Each recursive call further splits until base case
 * 
 * 5. Merge:
 *    - Merge two sorted halves
 *    - Compare nodes and link in sorted order
 *    - Return merged sorted list
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n) for recursive stack
 * https://leetcode.com/problems/sort-list/
 */
public class SortLists {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head, slow = head, fast = head;
        // find mid node first

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // temp is mid node, slow is mid+1 and fast is last node
        temp.next = null;
        // head to temp -> left list, slow to fast -> right list
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);
        return merge(left_side, right_side);
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode c1 = h1, c2 = h2;
        ListNode newHead = new ListNode(0), curr = newHead;

        while (c1 != null && c2 != null) {

            if (c1.val < c2.val) {

                curr.next = c1;
                curr = curr.next;
                if (c1.next == null) {
                    c1 = null;
                    break;
                }
                c1 = c1.next;

            } else {
                curr.next = c2;
                curr = curr.next;
                if (c2.next == null) {
                    c2 = null;
                    break;
                }
                c2 = c2.next;
            }
        }
        curr.next = c1 != null ? c1 : c2;
        return newHead.next;
    }

    public void printList(ListNode newHead) {
        ListNode curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
