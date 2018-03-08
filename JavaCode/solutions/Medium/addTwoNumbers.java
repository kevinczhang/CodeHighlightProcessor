/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Create carry to track the carry over
     * Create a pointer to track the node position
     * build the list while l1 not null or l2 not null or carry > 0
     *      reset next node and carry
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Since both lists are non-empty
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        int carry = (l1.val + l2.val) / 10;
        ListNode cur = head;
        // Go to next nodes
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null || carry > 0){
            int totalVal = carry;
            totalVal += l1 == null ? 0 : l1.val;
            totalVal += l2 == null ? 0 : l2.val;
            carry = totalVal / 10;
            cur.next = new ListNode(totalVal % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }
}