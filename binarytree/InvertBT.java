package binarytree;

public class InvertBT {
    // https://leetcode.com/problems/invert-binary-tree/

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // just change the positions of nodes
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // TreeNode temp = left;
        root.left = right;
        root.right = left;
        return root;
    }
}