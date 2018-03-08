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

    // Recursive Solution
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode root){
        if (root == null ||
                root.left == null && root.right == null) return root;
        // Convert right subtree before assign root.righ
        TreeNode rightSubtree = flattenTree(root.right);
        // Set root.right to flattened left subtree
        root.right = flattenTree(root.left);
        root.left = null; // set left to null
        // Find tail of the linked list
        TreeNode cur = root;
        while(cur.right != null)
            cur = cur.right;
        // Set right pointer to right sub tree
        cur.right = rightSubtree;
        return root;
    }

    // Iterative Solution
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}