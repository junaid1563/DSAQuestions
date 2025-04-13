/**
 * Determines if two binary trees are identical in structure and node values.
 * 
 * Approach:
 * 1. Uses recursive DFS (Depth First Search) to compare both trees
 * simultaneously
 * 2. Base cases:
 * - If both nodes are null -> trees are identical up to this point (return
 * true)
 * - If one node is null and other isn't -> trees are different (return false)
 * - If current nodes have different values -> trees are different (return
 * false)
 * 3. Recursively checks left and right subtrees
 * - Both left subtrees must be identical AND
 * - Both right subtrees must be identical
 *
 * Time Complexity: O(min(n,m)) where n,m are number of nodes in trees p and q
 * Space Complexity: O(min(h1,h2)) where h1,h2 are heights of trees (recursive
 * stack)
 *
 * https://leetcode.com/problems/same-tree/
 */
public class SameBT {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
