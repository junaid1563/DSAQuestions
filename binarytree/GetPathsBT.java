import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Binary Tree Paths (https://leetcode.com/problems/binary-tree-paths/)
 * 
 * Approaches:
 * 1. Recursive with String Building (binaryTreePaths)
 *    - Base case: If root is null, return empty list
 *    - If leaf node, return list with just the node value
 *    - Recursively get paths from left and right subtrees
 *    - Combine paths and prefix with current node value
 *    Time: O(n) where n is number of nodes
 *    Space: O(h) for recursion stack, h is height of tree
 * 
 * 2. DFS with Path Building (binaryTreePaths2) 
 *    - Use helper method with current path string
 *    - Add to result list when leaf node is reached
 *    - Build path string while traversing down the tree
 *    Time: O(n) where n is number of nodes
 *    Space: O(h) for recursion stack
 * https://leetcode.com/problems/binary-tree-paths/
 */

public class GetPathsBT {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        if (root.left == null && root.right == null) {
            List<String> ans = new ArrayList<>();
            ans.add(root.val + "");
            return ans;
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        left.addAll(right);
        for (int i = 0; i < left.size(); i++) {
            left.set(i, root.val + "->" + left.get(i));
        }
        return left;
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> ans = new ArrayList<>();
        setPaths(root, "", ans);
        return ans;
    }

    public void setPaths(TreeNode root, String path, List<String> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(path + root.val);
            return;
        }
        setPaths(root.left, path + root.val + "->", list);
        setPaths(root.right, path + root.val + "->", list);
    }
}
