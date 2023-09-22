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
    public ListNode mergeKLists (ListNode [] lists) {
        List <ListNode> list = new LinkedList <>();

        for (int i = 0; i < lists.length; i += 1) {
          for (ListNode curr = lists[i]; curr != null; curr = curr.next) 
            list.add (curr);
        }

        Collections.sort (list, Comparator.comparing (a -> a.val));
        for (int i = 0; i < list.size () - 1; i += 1) 
          list.get (i).next = list.get (i + 1);

        if (list.size () != 0) {
          list.get (list.size () - 1).next = null;
          return list.get (0);
        }

        return null;
    }
}