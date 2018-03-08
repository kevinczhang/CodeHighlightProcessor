/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode fakeHead = new ListNode(-1);
        ListNode pre = fakeHead;
        fakeHead.next = head;
        while(head != null && head.val == val){
            head = head.next;
            fakeHead.next = head;
        }

        while(head != null){
            if(head.val != val){
                pre = head;
                head = head.next;
            }
            else {
                head = head.next;
                pre.next = head;
            }
        }
        return fakeHead.next;
    }
}