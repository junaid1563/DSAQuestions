package linkedlist;

import java.util.Stack;

public class PalindromeList {
     public boolean isPalindrome(ListNode head) {
        int n = len(head);
        if(n==1){
            return true;
        }
        int mid = 0;
        if (n % 2 == 0) {
            // even
            mid = n / 2 ;
        } else {
            mid = (n +1)/ 2;
        }
        System.out.println("mid = " + mid);
        ListNode left = head, right = head;
        for (int i = 0; i < mid; i++) {
            right = right.next;
        }
        if(right.next==null){
           if(left.val!=right.val){
             return false;
           }else{
            return true;
           }
           
        }
        System.out.println("mid Node = " + right.val);
        ListNode revHead = reverseList(right);
        System.out.println("rev Node = " + revHead.val);
            
        left = head;
        right = revHead;
        while(revHead!=null){
            System.out.println("left Node = " + left.val+" right val = "+ right.val);
            if(left.val!=right.val){
                return false;
            }
            left = left.next;
            if(right.next==null){
                break;
            }
            right = right.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack();
        while (curr != null) {
            // pushing nodes to stack
            ListNode node = new ListNode();
            node.val = curr.val;
            stack.push(node);
            if (curr.next == null) {
                // last node
                break;
            }
            curr = curr.next;
        }

        ListNode newHead = null;
        curr = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (curr == null) {
                curr = node;
                newHead = node;
            } else {
                curr.next = node;
            }
        }
        return newHead;
    }

    public int len(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        return len;
    }
}
