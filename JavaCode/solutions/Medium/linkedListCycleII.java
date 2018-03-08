/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (first != null && second != null) {
            first = first.next;
            second = second.next;
            if (second != null)
                second = second = second.next;
            if (first == second)
                break;
        }

        if (second == null)
            return null;

        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}