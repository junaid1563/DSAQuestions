package binarytree;

/**
 * Merges two binary trees by creating a new binary tree where each node is the
 * sum of corresponding nodes from both trees.
 * 
 * Approach:
 * 1. Uses recursive DFS (Depth First Search) traversal
 * 2. For each position:
 * - If both nodes are null, returns null
 * - Creates a new node with sum of values from both trees (handling null cases)
 * - Recursively merges left and right subtrees
 * - For non-overlapping nodes, uses values from the tree that has a node
 * 
 * Time Complexity: O(min(m,n)) where m and n are number of nodes in the two
 * trees
 * Space Complexity: O(min(h1,h2)) where h1 and h2 are heights of the trees due
 * to recursion stack
 * 
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 */
public class Merge2BT {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            // when both left and right are null then we return
            return null;
        }

        // find val for new node
        int val = 0;
        if (root1 != null) {
            val += root1.val;
        }
        if (root2 != null) {
            val += root2.val;
        }
        // create new node
        TreeNode root = new TreeNode(val);
        // left subtree
        root.left = mergeTrees(root1 != null ? root1.left : root1, root2 != null ? root2.left : root2);
        // right subrtree
        root.right = mergeTrees(root1 != null ? root1.right : root1, root2 != null ? root2.right : root2);

        return root;
    }
}
