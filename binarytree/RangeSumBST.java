/**
 * Approach for Range Sum of BST
 * 
 * The approach uses recursive DFS traversal to find sum of nodes within given range:
 * 1. Base case: If root is null, return
 * 2. If current node value is within range [low,high], add to running sum
 * 3. Recursively search left subtree if:
 *    - Current value >= low OR >= high (indicating range exists in left)
 * 4. Recursively search right subtree if:  
 *    - Current value <= low OR <= high (indicating range exists in right)
 * 5. Finally return accumulated sum
 * 
 * Time Complexity: O(N) - visits each node once in worst case
 * Space Complexity: O(H) - recursion stack space, where H is height of tree
 * 
 * https://leetcode.com/problems/range-sum-of-bst/description/
 */
package binarytree;


public class RangeSumBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        findSum(root, low, high);
        return sum;
    }

    public void findSum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val >= low || root.val >= high) {
            // if any or both low and high are in left subtree
            findSum(root.left, low, high);
        }
        if (root.val <= low || root.val <= high) {
            // if any or both low and high are in right subtree
            findSum(root.right, low, high);
        }

    }
}
