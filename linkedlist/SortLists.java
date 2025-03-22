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
        System.out.println("left side");
        printList(left_side);
        System.out.println("right side");
        printList(right_side);
        return merge(left_side, right_side);
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode c1 = h1, c2 = h2;
        ListNode newHead = new ListNode(0), curr = newHead;

        while (c1 != null && c2 != null) {

            if (c1.val < c2.val) {
                System.out.println("c1 is less");
                ListNode node = new ListNode(c1.val);
                curr.next = node;
                if (c1.next == null) {
                    c1 = null;
                    break;
                }
                c1 = c1.next;

            } else {
                System.out.println("c2 is less");
                ListNode node = new ListNode(c2.val);
                curr.next = node;
                if (c2.next == null) {
                    c2 = null;
                    break;
                }
                c2 = c2.next;

            }

            curr = curr.next;
        }
        while (c1 != null && c1.next != null) {
            ListNode node = new ListNode(c1.val);
            curr.next = node;
            curr = curr.next;
            if (c1.next == null) {
                c1 = null;
                break;
            }
            c1 = c1.next;

        }
        while (c2 != null && c2.next != null) {
            ListNode node = new ListNode(c2.val);
            curr.next = node;
            curr = curr.next;
            if (c2.next == null) {
                c2 = null;
                break;
            }
            c2 = c2.next;

        }
        System.out.println("After merge");

        printList(newHead.next);

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
