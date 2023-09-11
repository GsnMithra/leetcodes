"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList (self, head: 'Optional[Node]') -> 'Optional[Node]':
        mapping = dict ()
        
        curr = head
        while curr:
            mapping[curr] = Node (curr.val)
            curr = curr.next
            
        curr = head
        while curr:
            if curr.next:
                mapping[curr].next = mapping[curr.next]
            if curr.random:
                mapping[curr].random = mapping[curr.random]
            curr = curr.next
        
        return mapping[head] if head else None