# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList (self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        
        headEven, tailEven = (None, None)
        headOdd, tailOdd = (None, None)
        
        def append (head, tail, value):
            if not head and head == tail:
                head = tail = ListNode (value)
            else:
                tail.next = ListNode (value)
                tail = tail.next
                
            return head, tail
        
        curr = head
        currIdx = 0
        while curr:
            if currIdx % 2 == 0:
                headEven, tailEven = append (headEven, tailEven, curr.val)
            else:
                headOdd, tailOdd = append (headOdd, tailOdd, curr.val)
            curr = curr.next
            currIdx += 1
        
        tailEven.next = headOdd
        return headEven