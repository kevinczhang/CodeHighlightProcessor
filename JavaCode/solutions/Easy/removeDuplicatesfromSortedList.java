/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cur = head;
        while(cur != null && cur.next != null){
            while(cur.val == cur.next.val){
                cur.next = cur.next.next;
                if(cur.next == null)
                    break;
            }
            cur = cur.next;
        }
        return head;
    }
}