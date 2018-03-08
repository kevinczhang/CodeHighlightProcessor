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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        if(Math.abs(leftHeight-rightHeight) <=1)
            return isBalanced(root.left) && isBalanced(root.right);
        else
            return false;
    }

    private int treeHeight(TreeNode root){
        if(root == null) return 0;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        return 1+Math.max(left, right);
    }
}