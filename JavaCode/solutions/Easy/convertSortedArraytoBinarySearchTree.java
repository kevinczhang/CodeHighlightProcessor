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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0) return null;

        int startIndex = 0, endIndex = num.length - 1;
        int midIndex = (startIndex + endIndex)/2;

        TreeNode root = new TreeNode(num[midIndex]);
        if(num.length == 1) return root;

        root.left = arrayToBST(num, startIndex, midIndex-1);
        root.right = arrayToBST(num, midIndex+1, endIndex);

        return root;
    }

    public TreeNode arrayToBST(int[] num, int start, int end){
        TreeNode root = null;
        if(start <= end){
            int mid = (start + end)/2;
            root = new TreeNode(num[mid]);
            if(start == end)
                return root;
            root.left = arrayToBST(num, start, mid-1);
            root.right = arrayToBST(num, mid+1, end);
        }

        return root;
    }
}