package binarytree;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        Node<Character> a = new Node('a');
        Node<Character> b = new Node('b');
        Node<Character> c = new Node('c');
        Node<Character> d = new Node('d');
        Node<Character> e = new Node('e');
        Node<Character> f = new Node('f');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        // depthFirstTraversal2(a);
        // breadthFirstTraversal2(a, 0);
        System.out.println(isExistDFS('e', a));
        System.out.println(isExistDFS2('p', a));
        System.out.println(isExistBFS(' ', a));
    }

    public static void depthFirstTraversal(Node<Character> root) {
        Stack<Node<Character>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Character> top = stack.pop();
            System.out.print(top.value + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public static void depthFirstTraversal2(Node<Character> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        depthFirstTraversal2(root.left);
        depthFirstTraversal2(root.right);
    }

    public static void breadthFirstTraversal(Node<Character> root) {
        // linked list is used as queue here. Adding to first and removing from last
        LinkedList<Node<Character>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Character> current = queue.removeFirst();
            System.out.println(current.value);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
    }

    public static void breadthFirstTraversal2(Node<Character> root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == 0) {
            System.out.println(root.value);
        }
        if (root.left != null) {
            System.out.println(root.left.value);
        }
        if (root.right != null) {
            System.out.println(root.right.value);
        }
        breadthFirstTraversal2(root.left, depth + 1);
        breadthFirstTraversal2(root.right, depth + 1);

    }

    public static boolean isExistDFS(char ch, Node<Character> root) {
        if (root == null) {
            return false;
        }
        if (root.value == ch) {
            return true;
        }
        return isExistDFS(ch, root.left) || isExistDFS(ch, root.right);
    }

    public static boolean isExistDFS2(char ch, Node<Character> root) {
        if (ch == root.value) {
            return true;
        }
        Stack<Node<Character>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Character> current = stack.pop();
            if (current.value == ch) {
                return true;
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return false;
    }

    public static boolean isExistBFS(char ch, Node<Character> root) {
        if (root.value == ch) {
            return true;
        }
        LinkedList<Node<Character>> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node<Character> current = queue.removeFirst();
            if (current.value == ch) {
                return true;
            } else {
                if (current.left != null) {
                    queue.addLast(current.left);
                }
                if (current.right != null) {
                    queue.addLast(current.right);
                }
            }
        }
        return false;
    }
}

class Node<T> {
    public T value;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}