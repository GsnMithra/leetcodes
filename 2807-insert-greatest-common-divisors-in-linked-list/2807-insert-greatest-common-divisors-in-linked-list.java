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
    public int greatestCD (int a, int b) {
        return (b == 0) ? a : greatestCD (b, a % b);
    }
    
    public ListNode insertGreatestCommonDivisors (ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            int a = curr.val;
            int b = curr.next.val;
            ListNode newNode = new ListNode (greatestCD (a, b));
            newNode.next = curr.next;
            curr.next = newNode;
            
            curr = curr.next.next;
        }
        
        return head;
    }
}