/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;

        TreeLinkNode cur, level = root, head = root;
        while(root.left != null){
            root.left.next = root.right;
            cur = root.right;
            while(level.next != null){
                level = level.next;
                cur.next = level.left;
                level.left.next = level.right;
                cur = level.right;
            }
            level = root.left;
            root = root.left;
        }
    }
}