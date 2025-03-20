package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Node {

    int val;
    Node next;
    Node random;

    public static void main(String[] args) {
        Node head = createList(new int[] { 10, 2, 30, 4, 50, 6 }, new int[] { 2, 1, -1, 5, 3, 4 });
        Node.printList(head);
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node createList(int[] arr, int[] random) {
        Node head = new Node(0), curr = head;
        Map<Integer, Node> nodes = new HashMap<>();
        // first create normal list without random nodes
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            curr.next = node;
            // put nodes and index in map
            nodes.put(i + 1, node);
            curr = curr.next;
        }
        System.out.println("Original Map = " + nodes.toString());

        curr = head.next;
        int c = 0;
        // now run loop to set random nodes
        while (curr != null && c < random.length) {
            // get random node at given index from map

            if (random[c] == -1) {
                System.out.println("random = " + random[c] + " map value = " + nodes.get(random[c]));
                curr.random = null;
            } else {
                System.out.println("random = " + random[c] + " map value = " + nodes.get(random[c]).val);
                curr.random = nodes.get(random[c]);
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
            c++;
        }

        return head.next;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.random == null) {
                System.out.print(curr.val + "-" + curr.random + " ");
            } else {
                System.out.print(curr.val + "-" + curr.random.val + " ");
            }

            if (curr.next == null) {
                curr = null;
                break;
            }
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * Creates a deep copy of a linked list where each node has two pointers: `next`
     * and `random`.
     * 
     * Approach:
     * 1. Traverse the original linked list and create a mapping from each original
     * node to its corresponding new node.
     * - Use a HashMap to store the mapping from the original node to the new node.
     * 2. Traverse the original linked list again to set the `next` and `random`
     * pointers for each new node.
     * - For each original node, set the `next` pointer of the corresponding new
     * node to the new node corresponding to the original node's `next` pointer.
     * - Similarly, set the `random` pointer of the corresponding new node to the
     * new node corresponding to the original node's `random` pointer.
     * 3. Return the new head node which is the deep copy of the original linked
     * list.
     * 
     * @param head The head of the original linked list.
     * @return The head of the deep copied linked list.
     */
    public Node copyRandomList(Node head) {

        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}