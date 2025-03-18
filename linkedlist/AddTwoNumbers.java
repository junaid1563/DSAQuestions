package linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        ListNode h2 = ListNode.createList(new int[] { 1, 2, 4 });
        ListNode head = ListNode.createList(arr);
        // ListNode.printList(head);
        ListNode.printList(addTwoNumbers(head, h2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1 = getNum(l1);
        long n2 = getNum(l2);
        long sum = n1 + n2;
        System.out.println("sum= " + sum);
        ListNode head = new ListNode(0);
        ListNode curr = head;
        if(sum==0){
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
}
