public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * Time is O(log(n)) and space is O(1).
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        // Try to find the node p and track node larger than it
        TreeNode next = null;
        TreeNode c = root;
        while (c != null && c.val != p.val) {
            if (c.val > p.val) {
                next = c;
                c = c.left;
            } else {
                c = c.right;
            }
        }

        // Node not found
        if (c == null)
            return null;
        // Node don't has right child
        if (c.right == null)
            return next;
        // Return left most node of right child
        c = c.right;
        while (c.left != null)
            c = c.left;

        return c;
    }
}