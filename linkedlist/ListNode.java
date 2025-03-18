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

    public static  ListNode createList(int[] arr) {
        ListNode head = new ListNode(0), curr = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode();
            node.val = arr[i];
            curr.next = node;
            curr = curr.next;
        }
        return head.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            if (curr.next == null) {
                curr = null;
                break;
            }
            curr = curr.next;
        }
        System.out.println();
    }
}