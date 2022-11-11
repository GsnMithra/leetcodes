/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        int position = 0;
        if (head == null) return null;
        if (head.next == null) return head;
        
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.next == null) return head;
            while (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
                if (tmp.next == null) return head;
            }
        }
        
        return head;
    }
}