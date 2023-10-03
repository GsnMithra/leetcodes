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
    public boolean palindrome;
    public ListNode front;
    public void palindromeUtil (ListNode rear) {
        if (rear == null)
            return;
        palindromeUtil (rear.next);
        if (this.front.val != rear.val)
            this.palindrome = false;
        this.front = this.front.next;
    }
    
    public boolean isPalindrome (ListNode head) {
        this.palindrome = true;
        this.front = head;
        
        palindromeUtil (head);
        return this.palindrome;
    }
}