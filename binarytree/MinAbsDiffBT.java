package binarytree;

public class MinAbsDiffBT {
    // not yet completed

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;

        return getMinDiff(root);
    }

    public int getMinDiff(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int left = getMinDiff(root.left);
        int lDiff = root.val, rDiff = root.val;
        if (root.left != null) {
            lDiff -= root.left.val;
        }
        if (root.right != null) {
            rDiff -= root.right.val;
        }
        int min = Math.min(Math.abs(lDiff), Math.abs(rDiff));
        int right = getMinDiff(root.right);
        return Math.min(left, Math.min(right, min));
    }
}