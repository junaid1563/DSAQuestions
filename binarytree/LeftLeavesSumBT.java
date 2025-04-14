package binarytree;
// https://leetcode.com/problems/sum-of-left-leaves/
public class LeftLeavesSumBT{

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, "");
    }

    public int sum(TreeNode root, String side){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            if(side.equals("left")){
                return root.val;
            }else{
                return 0;
            }
        }
        int left = sum(root.left, "left");
        int right = sum(root.right, "right");
        return left+right;
    }
}