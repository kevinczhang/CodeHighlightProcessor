/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftSub, TreeNode rightSub){
        if(leftSub == null && rightSub == null) return true;
        if(leftSub == null || rightSub == null) return false;

        if(leftSub.val == rightSub.val){
            return isSymmetric(leftSub.left, rightSub.right) && isSymmetric(leftSub.right, rightSub.left);
        }

        return false;
    }
}