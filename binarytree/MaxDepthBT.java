public class MaxDepthBT{
// https://leetcode.com/problems/maximum-depth-of-binary-tree/

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // depth of left subtree
        int left = maxDepth(root.left);
        // depth of left subtree
        int right = maxDepth(root.right);

        // return max of left and right +1
        return Math.max(left, right) + 1;
    }
}