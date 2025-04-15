package binarytree;

public class MinAbsDiffBT {
    // not yet completed

    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        getMinDiff(root);
        return min;
    }

    public void getMinDiff(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinDiff(root.left);
        // update min
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev.val));
        }
        // keep track of last node
        prev = root;
        getMinDiff(root.right);
    }
}