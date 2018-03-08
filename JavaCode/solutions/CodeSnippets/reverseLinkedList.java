/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Iterative Solution
    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        while (curr.next != end) {
            ListNode temp = begin.next;
            begin.next = curr.next;
            curr.next = curr.next.next;
            begin.next.next = temp;
        }
        return curr;
    }

    // Recursive Solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}