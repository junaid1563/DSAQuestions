package linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        // int n = length(head);

        // ListNode curr = head;
        // Sy stem .o ut.println("Leng th = " + n);
        // for (int i = 0; i < n / 2; i++) {
        // curr = curr.next;
        // }
        // return curr;
        // two pointer scheme for linkedlist
        ListNode one = head;
        ListNode two = head;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one;
    }

    public int length(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }
}
