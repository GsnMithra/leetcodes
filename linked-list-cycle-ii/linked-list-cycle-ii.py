# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None: return None
        if head.next == None: return None
        
        _iter = head
        traversed = dict()
        
        while _iter:
            if _iter in traversed: return _iter
            else: traversed[_iter] = 1
            _iter = _iter.next
            
        return None