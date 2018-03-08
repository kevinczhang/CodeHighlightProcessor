/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode pre = new ListNode(Integer.MAX_VALUE);
        pre.next = head;
        head = pre;
        ListNode cur = head.next, post = cur.next;

        if (cur.val != post.val) pre = pre.next;

        while (post.next != null) {
            if (cur.val == post.val || post.val == post.next.val) {
                cur = cur.next;
                post = post.next;
            } else {
                cur = cur.next;
                post = post.next;
                pre.next = cur;
                pre = pre.next;
            }
        }

        if (cur.val != post.val) {
            pre.next = post;
        } else {
            pre.next = null;
        }
        return head.next;

    }
}