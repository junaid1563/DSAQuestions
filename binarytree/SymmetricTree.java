package binarytree;

/**
 * Determines if a binary tree is symmetric around its center (mirror image of itself).
 * 
 * Approach:
 * 1. Handle base cases first:
 *    - If root has no children (leaf node), it's symmetric
 *    - If root has only one child, it's not symmetric
 * 2. For non-base cases, compare left and right subtrees:
 *    - Get root's left and right child nodes
 *    - Use recursive helper method to compare subtrees
 * 3. Two subtrees are symmetric if:
 *    - Both nodes are null, OR
 *    - Both nodes have same value AND
 *    - Left subtree's left == Right subtree's right AND
 *    - Left subtree's right == Right subtree's left
 * 
 * Time Complexity: O(n) where n is number of nodes
 * Space Complexity: O(h) where h is height of tree due to recursion stack
 * 
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            // if only one element is present
            return true;
        }
        if (root.left == null || root.right == null) {
            // any one side is null
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        return compareSubTrees(left, right);
    }

    public boolean compareSubTrees(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            // both trees are at null nodes
            return true;
        }
        if (left == null || right == null) {
            // any one tree is not null
            return false;
        }
        if (left.val != right.val) {
            // bot node values are not same
            return false;
        }

        // compare left.left with right.right and left.right with right.left
        return compareSubTrees(left.left, right.right) && compareSubTrees(left.right, right.left);
    }
}
