/**
 * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree.
 * 
 * Approach:
 * 1. Utilize the BST property: left subtree values < root value < right subtree values
 * 2. Compare root value with both p and q values:
 *    - If root value is less than both p and q, LCA must be in right subtree
 *    - If root value is greater than both p and q, LCA must be in left subtree
 *    - Otherwise, current root is the LCA (split point found)
 * 3. Recursively traverse left or right based on comparisons
 * 
 * Time Complexity: O(h) where h is height of tree
 * Space Complexity: O(h) for recursive call stack
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
package binarytree;

public class LeastCommonAncestorBT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}