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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curNode = head.next;

        while(curNode != null){
            head.next = curNode.next;
            curNode.next = fakeHead.next;
            fakeHead.next = curNode;
            curNode = head.next;
        }
        return fakeHead.next;
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