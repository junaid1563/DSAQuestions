package binarytree;

public class Array2BST {
    /**
     * Approach: Recursive Mid-point Division
     * Time: O(n), where n is length of input array
     * Space: O(log n) for recursion stack
     * 
     * 1. Since we need height-balanced BST and array is sorted:
     *    - Use middle element as root
     *    - Left subarray becomes left subtree
     *    - Right subarray becomes right subtree
     * 
     * 2. For each recursive call:
     *    - Find mid point
     *    - Create node with mid element
     *    - Recursively build left subtree from elements before mid
     *    - Recursively build right subtree from elements after mid
     * 
     * 3. Base case: when low >= high, return null
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(0, nums.length, nums);
    }

    public TreeNode convert(int lo, int hi, int[] nums) {
        if (lo >= hi) {
            return null;
        }
        // find mid
        int mid = (lo + hi) / 2;
        // create mid node
        TreeNode root = new TreeNode(nums[mid]);
        // now left will have left subtree
        TreeNode left = convert(lo, mid, nums);
        // right will have right subtree
        TreeNode right = convert(mid + 1, hi, nums);
        // add left to root.left
        root.left = left;
        // add right to root.right
        root.right = right;

        return root;
    }

}