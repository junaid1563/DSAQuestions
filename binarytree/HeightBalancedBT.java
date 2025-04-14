package binarytree;

public class HeightBalancedBT {
    /**
     * Approach for checking if binary tree is height-balanced:
     * 1. A binary tree is balanced if difference between heights of left and right
     * subtrees is not more than 1,
     * for all nodes in the tree
     * 2. For each node we:
     * - Calculate depth of left and right subtrees
     * - Check if difference is more than 1
     * - Recursively verify balance for left and right children
     * 3. Time Complexity: O(n^2) where n is number of nodes
     * 4. Space Complexity: O(h) for recursion stack where h is height
     * 
     * https://leetcode.com/problems/balanced-binary-tree/
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
