package linkedlist;

import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 9 };
        ListNode h2 = ListNode.createList(new int[] { 5, 6, 4, 9 });
        ListNode head = ListNode.createList(arr);
        // ListNode.printList(head);
        ListNode.printList(addTwoNumbers1(head, h2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1 = getNum(l1);
        long n2 = getNum(l2);
        long sum = n1 + n2;
        System.out.println("sum= " + sum);
        ListNode head = new ListNode(0);
        ListNode curr = head;
        if (sum == 0) {
            return head;
        }
        while (sum != 0) {
            ListNode node = new ListNode();
            long val = sum % 10;
            node.val = (int) val;
            curr.next = node;
            curr = curr.next;
            sum = sum / 10;
        }
        return head.next;
    }

    public static long getNum(ListNode head) {
        long n = 0, m = 1;
        ListNode curr = head;
        while (curr != null) {
            n = n + curr.val * m;
            m = m * 10;
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        return n;
    }

    /**
     * Adds two numbers represented by linked lists and returns the sum as a linked list.
     * Each node contains a single digit and the digits are stored in reverse order.
     * 
     * Approach:
     * 1. Initialize a dummy head node to build the result linked list.
     * 2. Use two pointers, c1 and c2, to traverse the input linked lists l1 and l2.
     * 3. Initialize a carry variable to handle sums greater than 9.
     * 4. Traverse both linked lists simultaneously:
     *    - Add corresponding digits from c1 and c2 along with the carry.
     *    - Update the carry for the next iteration.
     *    - Create a new node with the computed value and append it to the result list.
     *    - Move the pointers c1 and c2 to the next nodes.
     * 5. If one list is longer, continue adding the remaining digits along with the carry.
     * 6. If there is a carry left after processing both lists, add a new node with the carry value.
     * 7. Return the next node of the dummy head as the result linked list.
     * 
     * @param l1 The first linked list representing a number.
     * @param l2 The second linked list representing a number.
     * @return The linked list representing the sum of the two numbers.
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (c1 != null && c2 != null) {
            int n1 = c1.val;
            int n2 = c2.val;
            int val = n1 + carry + n2;
            System.out.println("n1 = " + n1);
            System.out.println("n2 = " + n2);
            if (val >= 10) {
                carry = 1;
                val -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode();
            node.val = val;
            curr.next = node;
            curr = curr.next;
            if (c1.next == null || c2.next ==null) {
                c1 = c1.next;
                c2 = c2.next;
                break;
            }
            
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            int n1 = c1.val;
            int val = n1 + carry;
            System.out.println("n1 = " + n1);

            if (val >= 10) {
                carry = 1;
                val -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode();
            node.val = val;
            curr.next = node;
            curr = curr.next;
            if (c1.next == null) {
                c1 = null;
                break;
            }
            c1 = c1.next;
        }
        while (c2 != null) {
            int n1 = c2.val;
            int val = n1 + carry;
            System.out.println("n2 = " + n1);

            if (val >= 10) {
                carry = 1;
                val -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode();
            node.val = val;
            curr.next = node;
            curr = curr.next;
            if (c2.next == null) {
                c2 = null;
                break;
            }
            c2 = c2.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode();
            node.val = 1;
            curr.next = node;
            curr = curr.next;
        }
        return head.next;
    }

    public static Stack<Integer> getStack(ListNode head) {
        Stack<Integer> s = new Stack();
        ListNode curr = head;
        while (head != null) {
            s.push(curr.val);
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        return s;
    }
}
