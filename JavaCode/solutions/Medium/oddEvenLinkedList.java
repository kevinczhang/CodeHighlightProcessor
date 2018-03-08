/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode cur = head, tail = head;
        int len = 1;
        while(tail.next != null){
        	tail = tail.next;
        	len++;
        }
            
        int count = 1;
        while(count <= len/2){
            ListNode even = cur.next;
            cur.next = cur.next.next;
            tail.next = even;
            tail = tail.next;
            tail.next = null;
            cur = cur.next;
            count++;
        }
        return head;
    }
}