package linkedlist;

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

        while (c1 != null && c1.next != null && c2 != null && c2.next != null) {
            ListNode node = new ListNode();
            if (c1.val < c2.val) {
                node.val = c1.val;
                c1 = c1.next;
            } else {
                node.val = c2.val;
                c2 = c2.next;
            }
            curr.next = node;
            curr = curr.next;
        }
        while (c1 != null && c1.next != null) {
            ListNode node = new ListNode();
            node.val = c1.val;
            c1 = c1.next;
            curr.next = node;
            curr = curr.next;
        }
        while (c2 != null && c2.next != null) {
            ListNode node = new ListNode();
            node.val = c2.val;
            c2 = c2.next;
            curr.next = node;
            curr = curr.next;
        }
        return newHead.next;
    }
}
