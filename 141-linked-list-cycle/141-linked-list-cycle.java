/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != null) {
            if(fast == null || fast.next == null || fast.next.next == null) return false;
            if(fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        } 
        
        return false;
    }
}