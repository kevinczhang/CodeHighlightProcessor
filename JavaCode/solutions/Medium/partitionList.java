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
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode larger, smaller, pre, cur, fakehead = new ListNode(-1), temp;
        fakehead.next = head;
        smaller = fakehead;
        larger = head;
        while (larger != null && larger.val < x) {
            smaller = smaller.next;
            larger = larger.next;
        }

        if (larger == null) return head;

        pre = larger;
        cur = pre.next;
        while (cur != null) {
            if (cur.val >= x) {
                cur = cur.next;
                pre = pre.next;
            } else {
                temp = cur.next;
                pre.next = cur.next;
                cur.next = larger;
                smaller.next = cur;
                smaller = smaller.next;
                cur = temp;
            }
        }
        return fakehead.next;
    }
}