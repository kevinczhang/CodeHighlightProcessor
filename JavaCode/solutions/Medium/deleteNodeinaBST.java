/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return replaceNode(root);

        TreeNode parent = root;
        TreeNode current = (key < root.val) ? root.left : root.right;

        while (current != null) {
            if (current.val == key) {
                if (current == parent.left) {
                    parent.left = replaceNode(current);
                } else {
                    parent.right = replaceNode(current);
                }
                return root;
            } else {
                parent = current;
                current = (key < current.val) ? current.left : current.right;
            }
        }
        return root;
    }

    TreeNode replaceNode(TreeNode node) {
        if (node.left == null && node.right == null) return null;
        if (node.left != null && node.right == null) return node.left;
        if (node.left == null && node.right != null) return node.right;

        TreeNode parent = node, current = node.right;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        if (node.right == current) {
            current.left = node.left;
        } else {
            parent.left = current.right;
            current.right = node.right;
            current.left = node.left;
        }
        return current;

    }
}