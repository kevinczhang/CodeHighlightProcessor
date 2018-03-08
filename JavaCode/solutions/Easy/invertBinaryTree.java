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
    public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		swapNodes(root, null);
		return root;
	}

	private void swapNodes(TreeNode firstNode, TreeNode secondNode) {
		if (firstNode == null && secondNode == null) return;

		if (firstNode != null){
			TreeNode temp = firstNode.left;
			firstNode.left = firstNode.right;
			firstNode.right = temp;
			swapNodes(firstNode.left, firstNode.right);
		}

		if (secondNode != null){
			TreeNode temp = secondNode.left;
			secondNode.left = secondNode.right;
			secondNode.right = temp;
			swapNodes(secondNode.left, secondNode.right);
		}
		return;
	}
}