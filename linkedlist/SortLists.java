package linkedlist;

/**
 * Approach to Sort a LinkedList using Merge Sort:
 * 
 * 1. Base Case:
 *    - If list is empty or has single node, return as is
 *    
 * 2. Find Middle Node:
 *    - Use slow and fast pointer technique
 *    - Slow moves one step, fast moves two steps
 *    - When fast reaches end, slow is at middle
 *    
 * 3. Split List:
 *    - Break list into two halves at middle point
 *    - First half: head to middle
 *    - Second half: middle+1 to end
 *    
 * 4. Recursive Sort:
 *    - Recursively sort both halves
 *    - Each recursion follows steps 1-3
 *    
 * 5. Merge:
 *    - Merge two sorted halves
 *    - Compare nodes and link in ascending order
 *    - Return merged sorted list
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n) for recursion stack
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
                ListNode node = new ListNode(c1.val);
                curr.next = node;
                curr = curr.next;
                if (c1.next == null) {
                    c1 = null;
                    break;
                }
                c1 = c1.next;

            } else {
                ListNode node = new ListNode(c2.val);
                curr.next = node;
                curr = curr.next;
                if (c2.next == null) {
                    c2 = null;
                    break;
                }
                c2 = c2.next;
            }
        }
        while (c1 != null) {
            ListNode node = new ListNode(c1.val);
            curr.next = node;
            curr = curr.next;
            if (c1.next == null) {
                c1 = null;
                break;
            }
            c1 = c1.next;
        }
        while (c2 != null) {
            ListNode node = new ListNode(c2.val);
            curr.next = node;
            curr = curr.next;
            if (c2.next == null) {
                c2 = null;
                break;
            }
            c2 = c2.next;
        }

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
