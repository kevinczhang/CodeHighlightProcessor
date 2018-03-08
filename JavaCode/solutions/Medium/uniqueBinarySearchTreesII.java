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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return createTree(1, n);
    }

    public List<TreeNode> createTree(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (end <= start) {
            TreeNode head = end < start ? null : new TreeNode(start);
            trees.add(head);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = createTree(start, i - 1);
            List<TreeNode> rights = createTree(i + 1, end);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode head = new TreeNode(i);
                    head.left = l;
                    head.right = r;
                    trees.add(head);
                }
            }
        }
        return trees;
    }
}