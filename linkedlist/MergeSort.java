package  linkedlist;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, curr = null;
        while (list1 != null && list2 != null) {
            ListNode next = new ListNode();
            System.out.println("l1 = " + list1.val + "l2 = " + list2.val);
            if (list1.val < list2.val) {
                next.val = list1.val;
                if (list1.next == null) {
                    break;
                }
                list1 = list1.next;
            } else {
                next.val = list2.val;
                if (list2.next == null) {
                    break;
                }
                list2 = list2.next;
            }
            if (curr == null) {
                head = next;
                curr = head;
            } else {
                curr.next = next;
                curr = curr.next;
            }
        }

        while (list1 != null) {
            System.out.println("l1");
            ListNode node = new ListNode();
            node.val = list1.val;
            if (curr == null) {
                head = node;
                curr = head;
            } else {
                curr.next = node;
                curr = curr.next;
            }
            if (list1.next == null) {
                break;
            }
            list1 = list1.next;
        }
        while (list2 != null ) {
            System.out.println("l2");
            ListNode node = new ListNode();
            node.val = list2.val;
            if (curr == null) {
                head = node;
                curr = head;
            } else {
                curr.next = node;
                curr = curr.next;
            }
            
            if (list2.next == null) {
                break;
            }
            list2 = list2.next;
        }
        return head;
    }
}