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
        TreeLinkNode first = root;
        while (first != null) {
            fillRow(first);
            // move to next level
            while (first != null && first.left == null
                    && first.right == null) first = first.next;
            if (first != null)
                first = (first.left != null) ? first.left : first.right;
        }
    }

    private void fillRow(TreeLinkNode cur) {
        while (cur != null) {
            if (cur.left != null && cur.right != null) {
                cur.left.next = cur.right;
            }

            // find next has-child node
            TreeLinkNode next = cur.next;
            while (next != null && next.left == null && next.right == null) {
                next = next.next;
            }
            if (next == null) break;
            // find next child and link it
            TreeLinkNode nextChild = (next.left != null) ? next.left : next.right;
            if (cur.right != null) {
                cur.right.next = nextChild;
            } else if (cur.left != null) {
                cur.left.next = nextChild;
            }

            // move to next has-child node directly
            cur = next;
        }
    }
}