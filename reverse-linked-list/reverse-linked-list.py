# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        if not head: return None
        if head.next == None: return head
        if head.next.next == None:
            a, b = head, head.next
            a.next = None
            b.next = a
            return b
        
        x, y, z = head, head.next, head.next.next

        x.next = None
        while(True):
            y.next = x
            x = y
            y = z
            if z.next == None:
                z.next = x
                return z
            z = z.next