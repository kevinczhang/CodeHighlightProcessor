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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean order = true;
        List<TreeNode> toVisit = new ArrayList<>();
        toVisit.add(root);
        while (!toVisit.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (TreeNode node : toVisit) {
                temp.add(node.val);
            }
            res.add(temp);
            for (int i = toVisit.size() - 1; i >= 0; i--) {
                TreeNode node = toVisit.get(i);
                if (order) {
                    if (node.right != null) next.add(node.right);
                    if (node.left != null) next.add(node.left);
                } else {
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                }
            }
            order = order ? false : true;
            toVisit = new ArrayList<TreeNode>(next);
        }
        return res;
    }
}