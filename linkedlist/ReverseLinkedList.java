package linkedlist;

import java.util.Stack;
/**
 * This method reverses a singly linked list using a stack.
 * 
 * Approach:
 * 1. Traverse the linked list and push each node onto a stack.
 * 2. Pop nodes from the stack to create a new reversed linked list.
 * 
 * Detailed Steps:
 * - Initialize a stack to store the nodes of the linked list.
 * - Traverse the original linked list:
 *   - For each node, create a new node with the same value and push it onto the stack.
 * - Initialize a new head pointer for the reversed linked list.
 * - Pop nodes from the stack:
 *   - For the first node popped, set it as the new head.
 *   - For subsequent nodes, link them to form the reversed list.
 * - Return the new head of the reversed linked list.
 * 
 * Time Complexity: O(n), where n is the number of nodes in the linked list.
 * Space Complexity: O(n), due to the stack storing all nodes.
 * https://leetcode.com/problems/reverse-linked-list/
 */

public class ReverseLinkedList {
     public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack();
        while(curr!=null){
            ListNode node = new ListNode();
            node.val=curr.val;
            stack.push(node);
            if(curr.next==null){
                curr=null;
                break;
            }
            curr=curr.next;
        }
        ListNode newHead = null;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            if(curr==null){
                newHead = node;
                curr=node;
            }else{
                curr.next = node;
                curr =curr.next;
            }
        }
    return newHead;
    }
}
