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
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        // Case 2: None of the left or the right child exist for the current node.
        if(t.left == null && t.right == null)
            return t.val + "";
        // Case 3: Only the left child exists for the current node.
        if(t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        // Case 1: Both the left child and the right child exist for the current node.
        // Case 4: Only the right child exists for the current node.
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    // Iterative Solution
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet < > ();
        String s = "";
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s += ")";
            } else {
                visited.add(t);
                s += "(" + t.val;
                if (t.left == null && t.right != null)
                    s += "()";
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
}