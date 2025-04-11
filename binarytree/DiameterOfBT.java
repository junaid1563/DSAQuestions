package binarytree;

public class DiameterOfBT {
// https://leetcode.com/problems/diameter-of-binary-tree/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return dia;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        dia = Math.max(dia, left + right);

        return Math.max(left, right) + 1;
    }
}