
package linkedlist;

import java.util.ArrayList;
import java.util.List;
/**
 * Partitions a linked list around a value x such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * Approach:
 * 1. Create an ArrayList to store nodes greater than or equal to x
 * 2. Create a dummy head node to build the new list
 * 3. Traverse the original list:
 *    - If current node value < x: append to the result list
 *    - If current node value >= x: add to ArrayList
 * 4. After traversal, append all nodes from ArrayList to result list
 * 5. Set the last node's next pointer to null to avoid cycles
 * 6. Return the next node after dummy head
 *
 * Time Complexity: O(n) where n is number of nodes in linked list
 * Space Complexity: O(n) to store nodes >= x in ArrayList
 *https://leetcode.com/problems/partition-list/
 * @param head The head node of the input linked list
 * @param x The partition value
 * @return Head of the partitioned linked list
 */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        List<ListNode> list = new ArrayList<>();
        ListNode newHead = new ListNode(0);
        ListNode curr1 = head;
        ListNode curr2 = newHead;
        while (curr1 != null) {
            if (curr1.val < x) {
                curr2.next = curr1;
                curr2 = curr2.next;
            } else {
                list.add(curr1);
            }
            curr1 = curr1.next;
        }
        for (int i = 0; i < list.size(); i++) {
            curr2.next = list.get(i);
            curr2 = curr2.next;
        }
        curr2.next = null;
        return newHead.next;
    }
}
