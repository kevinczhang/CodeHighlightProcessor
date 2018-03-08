/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        ListNode cur = head;
        dummyhead.next = cur;
        begin = dummyhead;
        int i = 0;
        while (cur != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, cur.next);
                cur = begin.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyhead.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        while (curr.next != end) {
            ListNode temp = begin.next;
            begin.next = curr.next;
            curr.next = curr.next.next;
            begin.next.next = temp;
        }
        return curr;
    }
}