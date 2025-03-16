package linkedlist;

public class HasCycle {

    /*
     * Approach
     * Using two pointers
     * if list has cycle, at one point one and two pointers will become same
     * otherwise two will become null or two.next==null
     * https://leetcode.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two != null && two.next != null) {

            one = one.next;
            two = two.next.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }

}