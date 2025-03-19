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

    public Node copyRandomList(Node head) {
        Node head2 = new Node(0), curr = head, curr2 = head2;
        Map<Integer, Node> nodes = new HashMap<>();
        // first create normal list without random nodes
        while (curr != null) {
            Node node = new Node(curr.val);
            curr2.next = node;
            // put nodes and index in map
            nodes.put(node.val, node);
            if (curr.next == null || curr2.next == null) {
                break;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }
        curr = head;
        curr2 = head2.next;

        // now run loop to set random nodes
        while (curr != null && curr2 != null) {
            // get random node at given index from map
            if (curr.random != null) {

                curr2.random = nodes.get(curr.random.val);
            } else {
                curr2.random = null;
            }

            if (curr.next == null || curr2.next==null) {
                break;
            }
            curr = curr.next;
            curr2=curr2.next;
            
        }
        return head2.next;
    }
}