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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resSet = new ArrayList<>();
        findPathSum(root, sum, new ArrayList<Integer>(), resSet);
        return resSet;
    }

    private void findPathSum(TreeNode root, int sum,
                             List<Integer> path, List<List<Integer>> resSet) {
        if (root == null) return;
        path.add(root.val);
        // get to a leaf and found a path
        if (root.left == null && root.right == null && sum == root.val) {
            // has to make a copy, otherwise the content may be changed
            List<Integer> curPath = new ArrayList<>(path);
            resSet.add(curPath);
        }
        findPathSum(root.left, sum - root.val, path, resSet);
        findPathSum(root.right, sum - root.val, path, resSet);
        path.remove(path.size()-1);
    }
}