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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
			TreeNode newRoot = new TreeNode(v);
			newRoot.left = root;
			return newRoot;
		}
        int curDepth = 1;
        Deque<TreeNode> parentLevel = new ArrayDeque<>();
        parentLevel.offerFirst(root);
        while(curDepth < d - 1){
            Deque<TreeNode> nextLevel = new ArrayDeque<>();
            while(!parentLevel.isEmpty()){
                TreeNode top = parentLevel.pollFirst();
                if(top.left != null)
                    nextLevel.offerFirst(top.left);
                if(top.right != null)
                    nextLevel.offerFirst(top.right);
            }
            parentLevel = nextLevel;
            curDepth++;
        }

        while(!parentLevel.isEmpty()){
            TreeNode top = parentLevel.pollFirst();
            TreeNode temp = top.left;
            top.left = new TreeNode(v);
            top.left.left = temp;
            temp = top.right;
            top.right = new TreeNode(v);
            top.right.right = temp;
        }
        return root;
    }
}