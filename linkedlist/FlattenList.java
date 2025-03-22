package linkedlist;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

/**
 * Flattens a multilevel doubly linked list into a single-level doubly linked list.
 * 
 * Approach:
 * 1. Traverse through the main linked list using two pointers - current and next
 * 2. When a node with child pointer is found:
 *    - Store the next pointer
 *    - Connect current node's next to child node
 *    - Set child node's prev to current node
 *    - Clear the child pointer
 * 3. Then traverse to the end of the child list, handling nested children recursively
 * 4. Once end of child list is reached, connect it with stored next pointer
 * 5. Continue this process until we reach end of main list
 * 
 * Time Complexity: O(N) where N is total number of nodes
 * Space Complexity: O(1) for iterative part, O(D) recursion stack where D is max depth
 * 
 * @param head Head node of the multilevel doubly linked list
 * @return Head of the flattened doubly linked list
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 */
public class FlattenList {
    
    public Node flatten(Node head) {
        Node curr = head, next = head;
        while (next != null) {
            curr = next;
            next = next.next;
            if (curr.child != null) {
                // child exists
                Node child = curr.child;
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                while (child != null) {
                    // reach last node in child
                    if (child.child != null) {
                        // if child also have child then run recursion
                        flatten(child);
                    }
                    if (child.next == null) {
                        break;
                    }
                    child = child.next;
                }
                child.next = next;
                if (next != null) {
                    next.prev = child;
                } else {
                    next = child;
                }
            }
            curr = curr.next;
        }
        return head;
    }

}