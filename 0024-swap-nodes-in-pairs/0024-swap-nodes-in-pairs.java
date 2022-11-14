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
    public ListNode appendList (ListNode head, int data) {
        ListNode tmp;
        if (head == null) { return new ListNode(data); }
        else {
            for (tmp = head; tmp.next != null; tmp = tmp.next);
            ListNode temp = new ListNode(data);
            tmp.next = temp;
            return head;
        }
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode returner = null;
        ListNode f = head.next, s = head;
        
        while (true) {
            
            // System.out.println(f.val);
            // System.out.println(s.val);
            
            if (f != null) returner = appendList(returner, f.val);
            if (s != null) returner = appendList(returner, s.val);
                
//             if (f != null && s != null) {
//                 returner = appendList(returner, f.val);
//                 returner = appendList(returner, s.val);
//             }
//             else return returner;
            
            
            if (f == null || s == null) return returner;
            if (f.next == null || s.next == null) return returner;
            
            f = f.next.next;
            s = s.next.next;
        }
    }
}