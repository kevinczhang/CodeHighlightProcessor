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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        Deque<TreeNode> curLevel = new ArrayDeque<TreeNode>();
        Deque<TreeNode> nextLevel = new ArrayDeque<TreeNode>();
        curLevel.addLast(root);

        while(!curLevel.isEmpty()){
            List<Integer> curList = new ArrayList<Integer>();
            for(TreeNode n : curLevel){
                curList.add(n.val);
                if(n.left != null) nextLevel.addLast(n.left);
                if(n.right != null) nextLevel.addLast(n.right);
            }
            res.add(curList);
            curLevel = new ArrayDeque<TreeNode>(nextLevel);
            nextLevel.clear();
        }
        return res;
    }
}