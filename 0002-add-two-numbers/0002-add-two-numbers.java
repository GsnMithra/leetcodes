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
        if (head == null) {
            head = new ListNode(data, null);
            return head;
        }
        ListNode tmp;
        for (tmp = head; tmp.next != null; tmp = tmp.next);
        tmp.next = new ListNode (data, null);
        return head;
    }   
    
    public ListNode addTwoNumbers(ListNode lx, ListNode ly) {
        int carry = 0;
        ListNode lz = null;
        int x, y;
        while (lx != null || ly != null || carry != 0) {
            x = (lx == null) ? 0: lx.val;
            y = (ly == null) ? 0: ly.val; 
            int ans = x + y + carry;
            carry = ans / 10;
            lz = appendList(lz, ans % 10);
            if (lx != null) { lx = lx.next; }
            if (ly != null) { ly = ly.next; }
        }
        
        return lz;
    }
}