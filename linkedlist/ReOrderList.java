package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class ReOrderList {
    public void reorderList(ListNode head) {
        System.out.println(len(head));
        int mid = len(head) / 2;
        ListNode curr = head;
        ArrayList<ListNode> queue = new ArrayList<>();
        // adding in queue(left half)
        for (int i = 1; i < mid; i++) {
            queue.add(curr);
            curr = curr.next;
        }
        Stack<ListNode> stack = new Stack<>();
        // pushing right half in stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int count = 0;
        curr = head;
        while (count < queue.size()) {
            ListNode qnode = queue.get(count);
            ListNode snode = stack.pop();
            qnode.next = snode;
            curr.next = snode;
            curr = curr.next;
            count++;
        }
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
    }

    public int len(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
