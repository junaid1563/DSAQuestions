package linkedlist;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, curr = null;
        while (list1 != null && list2 != null) {
            ListNode next = new ListNode();
            // System.out.println("l1 = " + list1.val + "l2 = " + list2.val);
            if (list1.val < list2.val) {
                next.val = list1.val;
                if (curr == null) {
                    head = next;
                    curr = head;
                } else {
                    curr.next = next;
                    curr = curr.next;
                }
                if (list1.next == null) {
                    list1 = null;
                    break;
                }
                list1 = list1.next;
            } else {
                next.val = list2.val;
                if (curr == null) {
                    head = next;
                    curr = head;
                } else {
                    curr.next = next;
                    curr = curr.next;
                }
                if (list2.next == null) {
                    list2 = null;
                    break;
                }
                list2 = list2.next;
            }

        }

        while (list1 != null) {
            // System.out.println("l1");
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
        while (list2 != null) {
            // System.out.println("l2");
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

    /**
     * Merges two sorted linked lists into one sorted linked list.
     *
     * Approach:
     * 1. Create a dummy node to act as the head of the merged list.
     * 2. Use a pointer `curr` to track the current end of the merged list.
     * 3. Traverse both input lists (`l1` and `l2`) simultaneously:
     * - Compare the current nodes of both lists.
     * - Append the smaller node to the merged list.
     * - Move the pointer of the list from which the node was taken.
     * 4. Once one of the lists is exhausted, append the remaining nodes of the
     * other list to the merged list.
     * 5. Return the merged list, which starts from the next node of the dummy head.
     *
     * 
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            // traverse normally until we have comparision left
            ListNode node = new ListNode();
            if (l1.val < l2.val) {
                node.val = l1.val;
                curr.next = node;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                curr.next = node;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // in the end only one list will have values, so we directly attacbh that node
        // to curr
        curr.next = l1 != null ? l1 : l2;
        return head.next;
    }
}