/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 * int label;
 * RandomListNode next, random;
 * RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // Solution without map, 3 rounds of scan
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;
            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            // restore the original list
            iter.next = next;
            iter = next;
        }
        return pseudoHead.next;
    }

    // Solution with Map
    public RandomListNode copyRandomList(RandomListNode head) {
        // No node
        if (head == null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode resHead = new RandomListNode(head.label);

        // Copy list with next pointers
        RandomListNode cur = head;
        RandomListNode resCur = resHead;
        map.put(cur, resCur);

        cur = cur.next;
        while (cur != null) {
            resCur.next = new RandomListNode(cur.label);
            map.put(cur, resCur.next);
            cur = cur.next;
            resCur = resCur.next;
        }

        cur = head;
        resCur = resHead;
        while (cur != null) {
            if (cur.random != null) {
                resCur.random = map.get(cur.random);
            } else {
                resCur.random = null;
            }

            cur = cur.next;
            resCur = resCur.next;
        }

        return resHead;
    }
}