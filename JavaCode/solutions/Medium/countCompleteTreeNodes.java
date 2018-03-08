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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        int left = getLeftHeight(root) + 1;
        int right = getRightHeight(root) + 1;

        if(left == right){
            return (2 << (left-1)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode n){
        if(n == null) return 0;
        int height=0;
        while(n.left!=null){
            height++;
            n = n.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode n){
        if(n == null) return 0;
        int height=0;
        while(n.right!=null){
            height++;
            n = n.right;
        }
        return height;
    }

    // Better Solution
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null) return 1;
        int height = 0;
        int nodesSum = 0;
        TreeNode curr = root;
        while(curr.left!=null) {
            nodesSum += (1<<height);
            height++;
            curr = curr.left;
        }
        return nodesSum + countLastLevel(root, height);
    }

    private int countLastLevel(TreeNode root, int height) {
        if(height == 1){
            if (root.right!=null) return 2;
            if (root.left!=null) return 1;
            return 0;
        }
        TreeNode midNode = root.left;
        int currHeight = 1;
        while(currHeight<height) {
            currHeight++;
            midNode = midNode.right;
        }
        if (midNode==null)
            return countLastLevel(root.left, height-1);
        return (1<<(height-1)) + countLastLevel(root.right, height-1);
    }
}