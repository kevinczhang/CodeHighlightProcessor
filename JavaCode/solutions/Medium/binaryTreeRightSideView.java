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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Deque<TreeNode> cur = new ArrayDeque<TreeNode>();

        cur.add(root);
        while(!cur.isEmpty()){
        	res.add(cur.getLast().val);
        	Deque<TreeNode> next = new ArrayDeque<TreeNode>();
        	while(!cur.isEmpty()){
        		TreeNode temp = cur.pop();
        		if(temp.left != null)
        			next.add(temp.left);
        		if(temp.right != null)
        			next.add(temp.right);
        	}
        	cur = next;
        }

        return res;
    }
}