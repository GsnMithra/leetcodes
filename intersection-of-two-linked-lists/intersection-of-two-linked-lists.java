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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> hm = new HashMap<>();
        
        for (ListNode tmp = headA; tmp != null; tmp = tmp.next) hm.put(tmp, 1);
        
        for (ListNode tmp = headB; tmp != null; tmp = tmp.next) if (hm.containsKey(tmp)) return tmp;
        
        return null;
    }
}