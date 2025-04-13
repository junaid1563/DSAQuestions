package binarytree;

public class PathSumBT {
    /**
     * Approach:
     * 1. Base case: If root is null, return false as we can't find any path sum
     * 2. Create a variable sum to keep track of path sum
     * 3. Use helper method findSum for recursive traversal:
     * - If current node is null, return false
     * - If it's a leaf node (no left and right child):
     * * Add current node value to sum
     * * Check if sum equals target
     * - For non-leaf nodes:
     * * Recursively check left and right subtrees
     * * Add current node value to sum for each path
     * * Return true if either path has target sum
     * Time: O(n) where n is number of nodes
     * Space: O(h) where h is height of tree for recursion stack
     * https://leetcode.com/problems/path-sum/
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = 0;
        return findSum(root, targetSum, sum);
    }

    public boolean findSum(TreeNode root, int ts, int s) {
        if (root == null) {
            // non leaf node
            return false;
        }
        if (root.left == null && root.right == null) {
            // leaf node
            s += root.val;
            if (ts == s) {
                return true;
            } else {
                return false;
            }
        }
        // traverse left subtree
        boolean left = findSum(root.left, ts, s + root.val);
        // traverse right subtree
        boolean right = findSum(root.right, ts, s + root.val);
        return left || right;
    }
}
