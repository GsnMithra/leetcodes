/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public void deleteNode (ListNode node) {
        if (node.next == null) {
            node = null;
            return;
        }

        ListNode curr = node, prev = null;
        while (curr.next != null) {
            prev = curr;
            curr.val = curr.next.val;
            curr = curr.next;
        }
        prev.next = null;
    }
}