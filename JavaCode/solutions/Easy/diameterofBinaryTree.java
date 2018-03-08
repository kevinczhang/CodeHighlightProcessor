/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null)
            return 0;
        int diameterOfLeftTree = diameterOfBinaryTree(root.left);
        int diameterOfRightTree = diameterOfBinaryTree(root.right);
        // Get edges' number of left subtree
        int leftTreeLen = root.left == null ? 0 : getLen(root.left) + 1;
        // Get edges' number of right subtree
        int rightTreeLen = root.right == null ? 0 : getLen(root.right) + 1;
        int rootLen = leftTreeLen + rightTreeLen;
        return Math.max(Math.max(diameterOfLeftTree, diameterOfRightTree), rootLen);
    }

    private int getLen(TreeNode node){
        if(node == null)
            return 0;
        int leftTreeLen = node.left == null ? 0 : getLen(node.left) + 1;
        int rightTreeLen = node.right == null ? 0 : getLen(node.right) + 1;
        return Math.max(leftTreeLen, rightTreeLen);
    }
}