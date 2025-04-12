package binarytree;
public class SubTree{
    /**
     * Approach:
     * 1. For isSubtree method:
     *    - Base case: if root is null, return false (can't find subtree in empty tree)
     *    - For each node in main tree:
     *      a. Check if current subtree matches subRoot using isSame method
     *      b. If no match, recursively check left and right subtrees
     * 
     * 2. For isSame method:
     *    - Base case 1: if both nodes are null, return true
     *    - Base case 2: if one node is null but other isn't, return false
     *    - For non-null nodes:
     *      a. Compare current node values
     *      b. Recursively check if left and right children are same
     * 
     * Time Complexity: O(m*n) where m and n are nodes in root and subRoot trees
     * Space Complexity: O(h) where h is height of main tree due to recursion
     */

    //  https://leetcode.com/problems/subtree-of-another-tree/
    public static void main(String[] args) {
        
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        // System.out.println("root = "+root.val +" subroot = "+subRoot.val+ ", isSame = "+isSame(root, subRoot));
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode r2) {
        if (root == null && r2 == null) {
            // both trees ends together
            return true;
        }
        if (root == null || r2 == null) {
            // one tree ended but another still has nodes
            return false;
        }

        if (root.val != r2.val) {
            // if nodes are not same in both trees
            return false;
        }

        return isSame(root.left, r2.left) && isSame(root.right, r2.right);
    }
}