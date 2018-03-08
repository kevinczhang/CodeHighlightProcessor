public class Solution {
    // Method converts a tree to a circular
    // Link List and then returns the head of the Link List
    public TreeNode bTreeToCList(TreeNode root) {
        if (root == null)
            return null;

        // Recursively convert left and right subtrees
        TreeNode left = bTreeToCList(root.left);
        TreeNode right = bTreeToCList(root.right);

        // Make a circular linked list of single node (or root).
        // To do so, make the right and left pointers of this node point to itself
        root.left = root.right = root;

        // Step 1 Concatenate the left list with the list with current node
        // Step 2 Concatenate the returned list with the right List
        return concatenate(concatenate(left, root), right);
    }

    // concatenate both the lists and returns the head of the List
    private TreeNode concatenate(TreeNode leftList, TreeNode rightList) {
        // If either of the list is empty, then return the other list
        if (leftList == null) return rightList;
        if (rightList == null) return leftList;

        // Store the last Node of left List
        TreeNode leftLast = leftList.left;
        // Store the last Node of right List
        TreeNode rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to the last node in the list
        leftList.left = rightLast;
        // Right of last node refers to the first node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }
}