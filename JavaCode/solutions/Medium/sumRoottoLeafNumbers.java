/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbersHelper(root, root.val, 0);
    }

    // path is the sum from root to the current node
    // sum is the sum of all root-to-leaf numbers up to the current node
    private int sumNumbersHelper(TreeNode root, int path, int sum) {
        if (root.left == null && root.right == null) { // reach a leaf
            return sum + path;
        }

        if (root.left != null) { // go to left subtree
            sum = sumNumbersHelper(root.left, path * 10 + root.left.val, sum);
        }
        if (root.right != null) { // go to right subtree
            sum = sumNumbersHelper(root.right, path * 10 + root.right.val, sum);
        }

        return sum;
    }
}